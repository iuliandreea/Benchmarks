#include <benchmark/benchmark.h>

bool primeUtil(int num)
{
    for (int i = 2; i <= num / 2; i++)
    {
        if (num % i == 0)
        {
            return true;
        }
    }
    return false;
}

static void nonRecCommonDivisor(benchmark::State &state)
{
    for (auto _ : state)
    {
        state.PauseTiming();
        int cd1 = rand() % state.range(0);
        int cd2 = rand() % state.range(0);
        benchmark::ClobberMemory();
        state.ResumeTiming();

        int gcd = 1;
        for (int i = 1; i <= cd1 && i <= cd2; i++)
        {
            if (cd1 % i == 0 && cd2 % i == 0)
            {
                benchmark::DoNotOptimize(gcd = i);
            }
        }
    }
}
BENCHMARK(nonRecCommonDivisor)->Arg(10)->Arg(100)->Arg(1000);

static void nonRecFactorial(benchmark::State &state)
{
    for (auto _ : state)
    {
        benchmark::ClobberMemory();
        int result = 1;
        for (int i = 1; i <= state.range(0); i++)
        {
            benchmark::DoNotOptimize(result *= i);
        }
    }
}
BENCHMARK(nonRecFactorial)->Arg(10)->Arg(100)->Arg(1000);

static void primeNumbers(benchmark::State &state)
{
    for (auto _ : state)
    {
        benchmark::ClobberMemory();
        int num = state.range(0);
        while (num >= 2)
        {
            benchmark::DoNotOptimize(primeUtil(num));
            benchmark::DoNotOptimize(num--);
        }
    }
}
BENCHMARK(primeNumbers)->Arg(10)->Arg(100)->Arg(1000);

BENCHMARK_MAIN();