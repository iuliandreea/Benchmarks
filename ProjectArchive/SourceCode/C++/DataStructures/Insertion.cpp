#include <benchmark/benchmark.h>
#include <queue>
#include <list>
#include <stack>
#include <vector>

static void arrayIndexInsertion(benchmark::State &state)
{
    for (auto _ : state)
    {

        state.PauseTiming();
        int arr[state.range(0) + 1];
        int pos = state.range(0) / 2;
        for (int i = 0; i < state.range(0); i++)
        {
            arr[i] = i;
        }
        state.ResumeTiming();

        for (int i = state.range(0); i > pos; i--)
        {
            benchmark::DoNotOptimize(arr[i] = arr[i - 1]);
        }
    }
    benchmark::ClobberMemory();
}
BENCHMARK(arrayIndexInsertion)->Arg(10)->Arg(100)->Arg(1000);

static void arrayLastInsertion(benchmark::State &state)
{
    for (auto _ : state)
    {

        state.PauseTiming();
        int arr[state.range(0) + 1];
        for (int i = 0; i < state.range(0); i++)
        {
            arr[i] = i;
        }
        state.ResumeTiming();

        benchmark::DoNotOptimize(arr[state.range(0)] = state.range(0));
    }
    benchmark::ClobberMemory();
}
BENCHMARK(arrayLastInsertion)->Arg(10)->Arg(100)->Arg(1000);

static void vectorInsertion(benchmark::State &state)
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

        vec.push_back(state.range(0));
    }
    benchmark::ClobberMemory();
}
BENCHMARK(vectorInsertion)->Arg(10)->Arg(100)->Arg(1000);

static void listInsertion(benchmark::State &state)
{
    for (auto _ : state)
    {
        state.PauseTiming();
        std::list<int> lst;
        for (int i = 0; i < state.range(0); i++)
        {
            lst.push_back(i);
        }
        benchmark::ClobberMemory();
        state.ResumeTiming();

        lst.push_back(state.range(0));
    }
    benchmark::ClobberMemory();
}
BENCHMARK(listInsertion)->Arg(10)->Arg(100)->Arg(1000);

static void queueInsertion(benchmark::State &state)
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

        q.push(state.range(0));
    }
    benchmark::ClobberMemory();
}
BENCHMARK(queueInsertion)->Arg(10)->Arg(100)->Arg(1000);

static void priorityQueueInsertion(benchmark::State &state)
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

        pq.push(state.range(0));
    }
    benchmark::ClobberMemory();
}
BENCHMARK(priorityQueueInsertion)->Arg(10)->Arg(100)->Arg(1000);

static void stackInsertion(benchmark::State &state)
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

        stk.push(state.range(0));
    }
    benchmark::ClobberMemory();
}
BENCHMARK(stackInsertion)->Arg(10)->Arg(100)->Arg(1000);

BENCHMARK_MAIN();