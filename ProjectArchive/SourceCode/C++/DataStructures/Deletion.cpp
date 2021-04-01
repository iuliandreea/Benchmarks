#include <benchmark/benchmark.h>
#include <queue>
#include <list>
#include <stack>
#include <vector>

static void arrayIndexDeletion(benchmark::State &state)
{
    for (auto _ : state)
    {

        state.PauseTiming();
        int arr[state.range(0)];
        for (int i = 0; i < state.range(0); i++)
        {
            arr[i] = i;
        }
        int pos = state.range(0) / 2;
        state.ResumeTiming();

        for (int i = pos; i < state.range(0) - 1; i++)
        {
            benchmark::DoNotOptimize(arr[i] = arr[i + 1]);
        }
    }
    benchmark::ClobberMemory();
}
BENCHMARK(arrayIndexDeletion)->Arg(10)->Arg(100)->Arg(1000);

static void arrayLastDeletion(benchmark::State &state)
{
    for (auto _ : state)
    {

        state.PauseTiming();
        int arr[state.range(0)];
        for (int i = 0; i < state.range(0); i++)
        {
            arr[i] = i;
        }
        state.ResumeTiming();

        benchmark::DoNotOptimize(arr[state.range(0) - 2] = arr[state.range(0) - 1]);
    }
    benchmark::ClobberMemory();
}
BENCHMARK(arrayLastDeletion)->Arg(10)->Arg(100)->Arg(1000);

static void vectorDeletion(benchmark::State &state)
{
    for (auto _ : state)
    {
        state.PauseTiming();
        std::vector<int> vec;
        for (int i = 0; i < state.range(0); i++)
        {
            vec.push_back(i);
        }
        benchmark::DoNotOptimize(vec.data());
        benchmark::ClobberMemory();
        state.ResumeTiming();

        vec.pop_back();
    }
    benchmark::ClobberMemory();
}
BENCHMARK(vectorDeletion)->Arg(10)->Arg(100)->Arg(1000);

static void listDeletion(benchmark::State &state)
{
    for (auto _ : state)
    {
        state.PauseTiming();
        std::list<int> lst;
        for (int i = 0; i < state.range(0); i++)
        {
            lst.push_back(i);
        }
        int pos = state.range(0) / 2;
        benchmark::ClobberMemory();
        state.ResumeTiming();

        lst.remove(pos);
    }
    benchmark::ClobberMemory();
}
BENCHMARK(listDeletion)->Arg(10)->Arg(100)->Arg(1000);

static void queueDeletion(benchmark::State &state)
{
    for (auto _ : state)
    {
        state.PauseTiming();
        std::queue<int> q;
        for (int i = 0; i < state.range(0); i++)
        {
            q.push(i);
        }
        benchmark::ClobberMemory();
        state.ResumeTiming();

        q.pop();
    }
    benchmark::ClobberMemory();
}
BENCHMARK(queueDeletion)->Arg(10)->Arg(100)->Arg(1000);

static void priorityQueueDeletion(benchmark::State &state)
{
    for (auto _ : state)
    {
        state.PauseTiming();
        std::priority_queue<int> pq;
        for (int i = 0; i < state.range(0); i++)
        {
            pq.push(i);
        }
        benchmark::ClobberMemory();
        state.ResumeTiming();

        pq.pop();
    }
    benchmark::ClobberMemory();
}
BENCHMARK(priorityQueueDeletion)->Arg(10)->Arg(100)->Arg(1000);

static void stackCreation(benchmark::State &state)
{
    for (auto _ : state)
    {
        state.PauseTiming();
        std::stack<int> stk;
        for (int i = 0; i < state.range(0); i++)
        {
            stk.push(i);
        }
        benchmark::ClobberMemory();
        state.ResumeTiming();

        stk.pop();
    }
    benchmark::ClobberMemory();
}
BENCHMARK(stackCreation)->Arg(10)->Arg(100)->Arg(1000);

BENCHMARK_MAIN();