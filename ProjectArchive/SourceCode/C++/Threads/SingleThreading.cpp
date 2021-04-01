#include <benchmark/benchmark.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

sem_t mutex, mutex2;

void *thread(void *arg)
{
    sem_wait(&mutex);
    sem_post(&mutex);
    return NULL;
}

void *switchTh(void *arg)
{
    for(int i = 0; i < 10; i++){
        sem_wait(&mutex2);
        sem_post(&mutex2);

        sem_wait(&mutex2);
        sem_post(&mutex2);
    }
    return NULL;
}

static void runThread(benchmark::State &state)
{
    for (auto _ : state)
    {
        sem_init(&mutex, 0, 1);
        pthread_t t;
        benchmark::DoNotOptimize(pthread_create(&t, NULL, thread, NULL));
        sem_destroy(&mutex);
        benchmark::ClobberMemory();
    }
}
BENCHMARK(runThread);

static void contextSwitch(benchmark::State &state)
{
    for(auto _ : state)
    {
        sem_init(&mutex2, 0, 1);
        pthread_t t;
        benchmark::DoNotOptimize(pthread_create(&t, NULL, switchTh, NULL));
        sem_destroy(&mutex2);
        benchmark::ClobberMemory();
    }
}
BENCHMARK(contextSwitch);

BENCHMARK_MAIN();