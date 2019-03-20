# Assistive Technology
## Basics of Impairment, disability, & handicap
* Impairment: Any loss or abnormality of psychological, physiological, or anatomical structure or function
* Disability: Any restriction or lack (resulting from an impairment) of ability to perform an activity in the manner or within the range considered normal for a human being
* Handicap: A disadvantage for a given individual, resulting from an impairment or disability, that limits or prevents the fulfillment of a role for that individual.
## Computers for access vs. as prostheses
* Access:
    * Increasingly a part of daily life (email, surfing, etc.)
    * Allowing all users to do basic computer tasks (typing)
* Prostheses
    * Using a computer for a task for which you may not otherwise use a computer (cooking, cleaning, controlling the lights, etc.)
## Redundant interfaces: What they are and why they're good
* Multiple opportunities to perform the same action in a way that the user pleases, common example is file manipulation in windows and macos
## Different types of impairments
* Motor
* Vision
* Speech
* Hearing
* Language
* Aging
* Multitasking
## Examples of solutions for impairments (keyboard modifications, magnification, braille output, audio)
* Bigger keyboard, different layout
* Speech input
* Joystick
* Trackball
* Sip and puff switches
* Head movement tracking
* Eye movement tracking
* Magnification
* Speech output
* Braille output
## Design of an interface for impaired users
* Swing accessibility API
* Common sense
# Intelligent Interfaces
## How could a menu adapt intelligently? Advantages and disadvantages?
* IDK, common sense
* Help w/context and search
## Two-sigma effect of human tutoring
* Students who receive one-on-one instruction perform two standard deviations better than students who receive traditional classroom instruction.
## What is a cognitive architecture
* Frameworks for building computer models of how people think and act
* Explain cognition with a psychological theory
* Simulate cognition with computer models
* Incorporate human abilities and limitations (learning & speedup, memory decay, etc)
## Declarative knowledge and production rules
* Chunks of facts
* Knowledge of situation
* Current and past goals
* Production = condition-action rule where action can act upon physical world or change memory contents
* Production is procedural programming esque
## Model tracing and buggy paths
* Relating observer actions with hidden cognitive states
* Think along with student and keep tract of cognitive state
* Buggy paths need to be incorporated, include help to go with these rules if fired
# Interfaces on the web
## Hypertext history and basics
* Used to be just presenting information with "convenient jumps"
* Meant for high level information
* There is a large body of information organized into fragments, the fragments relate to one another, the user needs only a small fraction of the fragments at any one time
## Different categorization of websites
* Sell products
* Advertise products or services
* Inform and announce
* Provide access (library, newspaper)
* Create discussions
* Nurture communities
## Is web site design different from GUI design?
### No
* Web site is a user interface with gui like elements
* Usability ideas for guis transfer to the web
* Evaluation like user testing and heuristic evaluation remain largely the same
### Yes
* You only design part of the interface, you don't control the browser
* User can manipulate many aspects of interaction (window size, fonts, navigation, bookmarking, etc)
* Some things are out of both your and users control (download times, security)
* Pages are a tiny part of the web space
* Scale of particular sites
## Know and understand basic types of web navigation
* Menu-tree navigation (menu heirarchy visible at all times, user can move through)
* Tab-stop navigation (like menu-tree, but uses tab physical metaphor)
* Index navigation (almost all info visible from top level)
* Pull down menu navigation
* Iconic navigation (info by picture clicking)
* Page turn - for sequential info, not useful for large sites
* Site map/table of contents (grouping in site map)
* Search
* Mixing navigation types
## Understand concepts of screen layout
* Balance is an essential components
* Focal point guides user's eye to content
* High-density is difficult to navigate without strong visual grouping
* Consistency is key
* Metaphors for interaction and recognition
## How might a gui be converted into a web site?
* links = buttons, input fields = text fields, applets
## Applet basics
* init() initialization
* start() performs work or starts threads
* stop() pauses when applet not visible
* destroy() final cleanup
* Can handle events
* Cannot read/write files
* Cannot make network connections
* Cannot start local program
* Cannot read certain system properties
* Cannot control certain aspects of window appearance
## SNIF-ACT: what it is and what it predicts
* Encapsulate web-browsing behavior in a computation model
* Information scent (modeling paths taken)
* Predicts which links user will click on
* When people decide to leave a site
* Theory
## Bloodhound: What it is and what it predicts
* System that analyses the information cues on a web site
* Part theory, part databse, part usable interface
# Beyond WIMP
## What is WIMP
* Windows, Icons, Menus, Pointers
## Be able to name 2 (of 12) aspects of non-command interfaces
* User focus
* Computer's role ( e.g. intelligent tutoring, model tracing)
* Interface control
* Syntax
* Object visibility
* Interaction stream (multi-threaded input/output, put that there moving)
* Bandwidth - lots of processing power and no lag
* Tracking feedback
* Turn taking - continuous stream for both players
* Interface locus - can do anything anywhere on any device
* User programming - smooth adaptation of objects, custom objects
* Software packaging (e.g. spell checking like microsoft is integrated everywhere)
## IGO: What it is, its intelligent interpretation, and possible problems
* Incorporates intelligent gaze-added input to an operating system
* Find object that maximizes gaze-object * object-history
* Can leave before click
* Gaze dragging
* Handling two "cursors"
# Interfaces off the desktop
## Handhelds: design guidelines and a couple examples
* Consider satellite v. stand-alone device
* Avoid use of pluralized and pop-up windows
* Integrate functionality and minimize navigation
* Specify the rigth controlls for the device
* Don't require shifting input modes
* Don't require a lot of scrolling
* Palm pilot
## Kiosks: Design guidelines and an example
* Transactional or Explorational
* Touch screen, touchable objects (large, high contrast, separated), no keyboard, no drag-and drop, no scrolling
* Explot context
* e.x. amtract multi-ride tocket
## In-Car interfaces: driver distraction basics
* Cell phone use can affect lane keeping, speed control, general attention, risk of collision
* Cognitive distraction
## How might a GUI be mapped onto an in-car interface?
* Common sense
## Ubiquitous computing: basics of tabs, pads, and boards
* Tabs - tiny inch-scale computers everywhere (active badges)
* Pads - cross between laptop and paper
* Boards - poster-sized computers can be on a wall
