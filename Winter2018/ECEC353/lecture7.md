# Threads (mutex)
* Why we need them

```C
#include <stdio.h>
#include <pthread.h>

#define LOOPS 10000

int val = 0;

void * thread (void * data)
{
    int i;
    for (i = 0; i < LOOPS; i++)
    {
        val--;
    }
    return NULL;
}

int main(int argc, char * argv[])
{
    int i, ret;
    pthread_t worker;
    ret = pthread_create(&worker, NULL, thread, NULL);
    if (ret)
    {
        fprintf(stderr, "Failed to create thread\n");
        return EXIT_FAILURE;
    }
    for(i = 0; i < LOOPS; i++)
    {
        val++;
    }
    pthread_join(worker, NULL);
    printf("val = %d\n", val);
    return 0;
}
```

* The val is basically pretty random
* gcc -S builds out assembly for a project
* xor with yourself zeros you out
* Lecture went over that a result may not be put back in ram before being modified by another thread
* No sync happening

# Solutions
* You can turn off interrupts while reading/writing
* Atomic operations
* Mutex

```C
#include <pthread.h>

pthread_mutex_t mtx = PTHREAD_MUTEX_INITIALIZER;

pthread_mutex_lock(&mtx);
// critical section
pthread_mutex_unlock(&mtx);
```
* What happens when you need to modify or work with multiple mutex-protected variables?
* There is a small, but no-zero chance, where if you lock the n mutexes in different orders, you can deadlock

# Notes
* Global struct initialization requires using "." initialization
* Now going over condition variables and the functions pthread_cond_wait() and pthread_cond_signal()
* Look at the example code for a solid example
* You can send the signal before or after you release the mutex, however it does matter when dealing with real time signals

