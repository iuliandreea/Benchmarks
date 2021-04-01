#include <benchmark/benchmark.h>
#include <string>

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

int factorialUtil(int number)
{
    if (number >= 1)
    {
        return number * factorialUtil(number - 1);
    }
    else
    {
        return 1;
    }
}

int commonDivisorUtil(int n1, int n2)
{
    if (n2 == 0)
    {
        return n1;
    }
    return commonDivisorUtil(n2, n1 % n2);
}

std::string reverseUtil(std::string &str, int i = 0)
{
    int n = str.length();
    if (i == n / 2)
        return str;
    std::swap(str[i], str[n - i - 1]);
    return reverseUtil(str, i + 1);
}

static void recCommonDivisor(benchmark::State &state)
{
    for (auto _ : state)
    {
        state.PauseTiming();
        int cd1 = rand() % state.range(0);
        int cd2 = rand() % state.range(0);
        int gcd = 1;
        benchmark::ClobberMemory();
        state.ResumeTiming();

        benchmark::DoNotOptimize(gcd = commonDivisorUtil(cd1, cd2));
    }
}
BENCHMARK(recCommonDivisor)->Arg(10)->Arg(100)->Arg(1000);

static void recFactorial(benchmark::State &state)
{
    for (auto _ : state)
    {
        int result = 1;
        benchmark::ClobberMemory();
        benchmark::DoNotOptimize(result = factorialUtil(state.range(0)));
    }
}
BENCHMARK(recFactorial)->Arg(10)->Arg(100)->Arg(1000);

static void reverseString(benchmark::State &state)
{
    for (auto _ : state)
    {
        state.PauseTiming();
        std::string str = "";
        for (int i = 0; i < state.range(0); i++)
        {
            str += "a";
        }
        benchmark::ClobberMemory();
        state.ResumeTiming();
        benchmark::DoNotOptimize(str = reverseUtil(str));
    }
}
BENCHMARK(reverseString)->Arg(10)->Arg(100)->Arg(1000);

BENCHMARK_MAIN();