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
        sem_init(&mutex, 0, state.range(0) / 2);
        pthread_t t[state.range(0)];
        for(int i = 0; i < state.range(0); i++){
            benchmark::DoNotOptimize(pthread_create(&t[i], NULL, thread, NULL));
        }
        for(int i = 0; i < state.range(0); i++){
            pthread_join(t[i], NULL);
        }
        sem_destroy(&mutex);
        benchmark::ClobberMemory();
    }
}
BENCHMARK(runThread)->Arg(2)->Arg(5)->Arg(10)->Arg(20);

static void contextSwitch(benchmark::State &state)
{
    for(auto _ : state)
    {
        sem_init(&mutex2, 0, state.range(0) / 2);
        pthread_t t[state.range(0)];
        for(int i = 0; i < state.range(0); i++){
            pthread_create(&t[i], NULL, switchTh, NULL);
        }
        for(int i = 0; i < state.range(0); i++){
            pthread_join(t[i], NULL);
        }
        sem_destroy(&mutex2);
        benchmark::ClobberMemory();
    }
}
BENCHMARK(contextSwitch)->Arg(2)->Arg(5)->Arg(10)->Arg(20);

BENCHMARK_MAIN();