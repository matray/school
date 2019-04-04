# Going over memory today

* All intel processors on start are in 8088 mode until you build up to features
* (or 8086)
* They were 16 bits
* 16 bits means 64 K of memory
* From 0x0000 to 0xFFFF
* 16 bytes are in a paragraph
* To address 16 bytes, you need 4 bits (0x0000 to 0x000F, paragraph 0)
* At 0x0010, you are in the next paragraph which is also 16 bytes
* Logical addresses consist of two parts, a segment and an offset
* It looks like: 0x0001:0x0001, paragraph 1, byte 1
* Can address up to 64 K
* Imagine we have 20^2 data bus (1 MB)
* Shift logical address left by four bytes, implies the lowest base of segment address
* Add base of segment to offset and we now forward to address space
* You basically continue from base segment up to 64 K in the memory allotted

# Protected Mode
* Intel introduced protected mode segmentation
* You could start a segment on any byte and then go onward even past 64 K
* Other way is called real mode
* Protected mode means you don't have to start at a normal address, but can specify higher so long as your software supports it and can reach higher than 64 K
* Problems with real mode:
* You now can specify bytes in nearly unlimited ways
* Protected mode also let you specify the limit of the address space in memory
* Protected mode also had permission buts
* New segment descriptor: 2-bit permission but, 1?2?-bit ?, then the rest is an index and that is your segment
* Segment descriptors are 64 bits
* Base address is most important thing in there (as well as the limit/size)

# Explaining the segment descriptor
* Entries go into the global descriptor table as well as the local descriptor table
* You normally have 5?
* S0: Null descriptor
* S1: Text/Code section
* S2: Data segment (also stack info)
* S3: Kernel Text/Code section
* S4: Kernel Data segment (also stack info)
* Table is constructed in the base while in real mode
* Then we can turn on protected mode and use big segments and go out of the 1MB boundary
* Local descriptor table is available per process, the Linux kernel doesn't use it unless you're running wine
* Windows uses it for thread local storage and thread stacks
* Then take beginning of paragraph byte of global table and put it in a special register (gdrt - Global descriptor register table) and there is also the ldtr register
* The 2?1?-bit ? is actually an indicator for what table you are using
* One for gdtr and one for ldtr
* We have effectively transitioned into 4Gigs of memory
* Now you can access 4GB of memory
* It's all pretty hacky
* Makes it the job of the programmer to make sure not to write outside of their segment

# So how to we make this easier?
* We have virtual address space and paging
* Define some things first
* Segment (index, table index, permission) : Offset is a logical address
* You get converted into a physical address based on the global descriptor table
* These are called linear addresses
* Linear addresses are equal to Physical addresses (note that this changes when paging is turned on)
* You can implement logical addresses on top of paging
* We turn off logical addressing because paging makes sense on top of linear addressing more than anything
* Protected mode segmentation with very simple segments is how you should keep things
* If everything starts at zero bas addr, has a size that's maxxed out (using the large bit) then you specify all global descriptors to cover the 4 GB then all you change is the offset
* By 32 bit machines, you can now specify all offsets
* Paging only makes sense when you can reach out to the offset max size and address all elements of memory
* Then Logical addresses = linear addresses = physical addresses
* So now how do we restrict programs and their memory access rules

# Paging
* Lets each process think it owns all memory
* When paging is on, all addresses are virtual addresses
* Whenever you want memory, you need at least one page
* Pages are often 4K (can be changed)
* Imagine a 32-bit virtual address
* Somehow we know the base address of a page frame in physical memory
* Then we can offset to find our byte
* 2^12 allows us to address 4KB
* 12 least significant bits go to this
* So how do we find the address of the page in memory?
* The memory management unit is the only thing that can access base addresses after paging is turned on
* Before we had a global descriptor table
* Now we have a page table
* The page table has entries that are 32 bits too
* The entry there is 20 bits for the page base address, 12 bits for flags
* Page tables need to fit within pages, so how do you fit a page table into memory because it is quite large
* You can fit exactly 1024 entries
* A single page table entry maps enough to support up to 4MB
* That's not 4 GB, so you need more pages of page  entries to keep track of pages
* So you have another page of page table entries to find page table pages for page table entries
* 2^10 = 1024, we can access individual page entries in a page table page
* 32 bit virtual addr: least significant 12 bits is offset, 10 bits is for page table entry (10 bits get left shifted to skip around)
* With the double page entries lookup we have 4GB looking at individual bytes
* 32-bit virtual address = 10bits for page table of page table location, 10 bits for page table entry, 12 bits for offset in 4KB page
* Want to skip every 4th byte, so we left shift 2 with the page of pages and in the actual page
* How do we find the starting address of the page of pages lookup table?
* It is loaded with a special register cr3 (control register 3)
* This page is called the page directory
* The inner pages are called page tables
* The inner inner pages are just pages
* This all happens now in the memory management unit, it is the only think using physical addresses
* The kernel goes in fills in the page tables
* That's all it does
* The kernel can access cr3
* The kernel's process know the base addresses
* This process is called the page walk
* You've taken 20 bits and correlated it to the page, then add 12 bits to get the byte
* The tld (translation lookaside buffer) does the walk, 20 bit virtual addresses on the one side and 20 bit physical addresses on the other
* This is slow the tlb (which is hardware) makes it fast
* This is why you should make sure to not for loop to addresses all over the place
* The oldest tlb entry gets evicted first
* Good to have arrays so you don't jump around a lot

# Solving data locality
* PSE - allows you to index 4MB as well as 4KB pages at the same time
* Modify bits in a page table entry's flags entry
* If hardware supports it, you can have certain page table entries that effectively have the large page bit set
* We shall call this page Jumbo page
* When this jumbo page flag is set, we can now modify the virtual address space
* You now point to 4MB after the first look up (walk stops early)
* Virtual addresses now look like 10 bits for lookup and 22 bits for offset
* This is called PSE - page size extension
* This is how you optimize for large data random access
* keeps tlb from running amuck
* You can tune your kernel to use whatever page size you want now that there's hardware support for it
* PAE - physical address extension - localizes 32 bit addresses to 64 bit addresses per process
* Each process is still limited to 4 GB of ram, but address space can use up to however much in 64 gb support
* To do this, you need to increase the size of your page table entries (double the size)
* Still likely 4KB pages, and still similar virtual address space
* A page table entry is no longer 20 bits, it is 52 bits to use the 64bit address space
* Interesting because page size hasn't changes
* Now page tables have entries that take up double the size, you can only hold 512 references
* Virtual address now has 9 bits for the inner page table entry as it doesn't hold as much (12 bits still for the offset)
* We now shift every 8 bytes in the lookup (left shift 3)
* Outer page table also uses 9 bits and 3 left shift
* Each outer page only references 1GB now
* So we need an outer outer page!
* 2 bits left over in virtual address space are used for an outer outer page!
* Only has 4 entries at this point.
* Inner most page table is called a page table
* Second inner most is called a page directory
* Outer is called Page Directory Pointer Table
* This allows processes on 32 bit machines to take advantage of 64 bit memory address space, but capped at their initial 32 bit machine memory address cap (4GB)
* The 32 bit kernel on the 64 bit hardware needs to be able to understand the translation
* Need software and hardware support for this set up
* If we turn on jumbo pages here, we only support 2MB
* But you could remove another page walk indirection

# Other flags
* Global flags can specify not to evict from the tlb
* kernel uses the flags to map itself into every processes address space
* Kernel is like 890MB
* Kernel gets mapped into virtual address space
* There is a present flag that can specify if something can be moved to swap with the tlb/software support
* If trying to access that page, the mmu will say it isn't present and throw an exception on the kernel and it will be asked to fill in the memory for it
