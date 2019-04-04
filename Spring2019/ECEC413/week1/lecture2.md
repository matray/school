# Coding on
* xunil-03
* xunil-05 (1080 GTX)

# Models
* Amdahl's law
    * Make the common case fast

* execution time without enhancement (Eold)
* execution time with enhancements (Enew)
* Speedup = Eold/Enew
* Enew = Eold $((1-f) + \frac{f}{x})$
* 0<=f<=1
* f is how much can be enhanced
* x is speedup due to enhancement
* Speedup = $\frac{1}{(1-f) + \frac{f}{x}}$

# Example
* 25% of code is floating point
* 75% of code is INT
* Option 1: Speedup FP operations by 5x
* S = $\frac{1}{(1-0.25) + \frac{0.25}{5}} = 1.25$
* Option 2: Speedup INT operations by 2x
* S = $\frac{1}{(1-0.75) + \frac{0.75}{2}} = 1.6$

# Example
* Code profiled, some fraction of the code (f) is completely serial
* The rest of it can be made parallel
* If we do make that parallel, how much faster is the program?
* s = serial code
* p = parallel possible code
* N = number of processors
* embarrassingly parallel = trivially parallelize-able
* s + p = 1
* speedup = $\frac{1}{s+\frac{P}{N}}$
* N = $\inf$
* speedup = $\frac{1}{s}$
* If 5% of code is serial, get a speedup of 20x


# Review of the Law
* Implicit assumption that the problem itself remains the same
* Assuming the problem does not scale with N

# Example
* Grid-based simulation
* One thread for each processor
* More processors and developer will scale to use those processors

# Gustafson
* In the 80s, someone from IBM (Gustafson) said this law doesn't make sense
* He assumed that if given more processors, you will scale the problem appropriately.
* Serial code: s + N * p
* Parallel code: s + p
* s+p = 1
* Speedup = s + N * p
* S = s+ N (1-s)

# Roofline model (bottleneck)
* Memory bound, compute bound
* Bottleneck data transfer
* Attainable GFLOPS = min(Peak FP performance, Peak memory bandwidth)

# Example
* Peak FP performance: 16 GFLOPs
* Peak mem bandwidth: 16 GBytes/sec
* Will eventually bottleneck

# Example SAXPY loop
* y = ax + y
* 32-bits, Single precision
* a is a constant

```C
int i;
for (i=0; i<n; i++)
{
    y[i] = a * x[i] + y[i]
}
```
* Arithmetic intensity = Total FP operations / Total data transferred (bytes)
* 2/12 is the intensity of this program (0.167)
* The attainable GFLOPS = 0.167 FLOPS/Bytes * 16 GBytes/sec = 2.67 GFLOPS
* Memory bound operation

# Writing parallel programs
* Decompose computation into tasks/threads
* Allocation of tasks to processors with different computing capabilities
* Synchronization between tasks

# Parallel histogram construciton
* Chunk it up baby
* Pass to thread (chunksize, tid, n,A, num_threads

```C
if (tid < num_threads - 1)
{
    for(i = tid * chunksize; i < (tid + 1)* chunksize; i++)
    {
        bin[A[i]] += 1
    }
}
```

* Best solution is to give each thread it's own local data structure to prevent shared data issues

