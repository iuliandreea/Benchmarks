#include <benchmark/benchmark.h>
#include <queue>
#include <list>
#include <stack>

static void staticArrayCreation(benchmark::State &state)
{
    for (auto _ : state)
    {
        int staticArr[state.range(0)];
        for (int i = 0; i < state.range(0); i++)
        {
            benchmark::DoNotOptimize(staticArr[i] = i);
        }
    }
    benchmark::ClobberMemory();
}
BENCHMARK(staticArrayCreation)->Arg(10)->Arg(100)->Arg(1000);

static void dynamicArrayCreation(benchmark::State &state)
{
    for (auto _ : state)
    {
        int *dynamicArr = new int[state.range(0)];
        for (int i = 0; i < state.range(0); i++)
        {
            benchmark::DoNotOptimize(dynamicArr[i] = i);
        }
    }
    benchmark::ClobberMemory();
}
BENCHMARK(dynamicArrayCreation)->Arg(10)->Arg(100)->Arg(1000);

static void vectorCreation(benchmark::State &state)
{
    for (auto _ : state)
    {
        std::vector<int> vec;
        for (int i = 0; i < state.range(0); i++)
        {
            vec.push_back(i);
        }
    }
    benchmark::ClobberMemory();
}
BENCHMARK(vectorCreation)->Arg(10)->Arg(100)->Arg(1000);

static void listCreation(benchmark::State &state)
{
    std::list<int> lst;
    for (auto _ : state)
    {
        for (int i = 0; i < state.range(0); i++)
        {
            lst.push_back(i);
        }
    }
    benchmark::ClobberMemory();
}
BENCHMARK(listCreation)->Arg(10)->Arg(100)->Arg(1000);

static void queueCreation(benchmark::State &state)
{
    for (auto _ : state)
    {
        std::queue<int> q;
        for (int i = 0; i < state.range(0); i++)
        {
            q.push(i);
        }
    }
    benchmark::ClobberMemory();
}
BENCHMARK(queueCreation)->Arg(10)->Arg(100)->Arg(1000);

static void priorityQueueCreation(benchmark::State &state)
{
    for (auto _ : state)
    {
        std::priority_queue<int> pq;
        for (int i = 0; i < state.range(0); i++)
        {
            pq.push(i);
        }
    }
    benchmark::ClobberMemory();
}
BENCHMARK(priorityQueueCreation)->Arg(10)->Arg(100)->Arg(1000);

static void stackCreation(benchmark::State &state)
{
    for (auto _ : state)
    {
        std::stack<int> stk;
        for (int i = 0; i < state.range(0); i++)
        {
            stk.push(i);
        }
    }
    benchmark::ClobberMemory();
}
BENCHMARK(stackCreation)->Arg(10)->Arg(100)->Arg(1000);

BENCHMARK_MAIN();