#include <benchmark/benchmark.h>
#include <queue>
#include <list>
#include <stack>
#include <vector>
#include <deque>

static void succArrayFind(benchmark::State &state){
    for(auto _ : state){

        state.PauseTiming();
        int arr[state.range(0)];
        for(int i = 0; i < state.range(0); i++){
            arr[i] = i;
        }   
        int succ = state.range(0) / 2;
        state.ResumeTiming();

        for(int i = 0; i < state.range(0); i++){
            if(arr[i] == succ){
                break;
            }
        }
    }
    benchmark::ClobberMemory();
}
BENCHMARK(succArrayFind)->Arg(10)->Arg(100)->Arg(1000);

static void failArrayFind(benchmark::State &state){
    for(auto _ : state){

        state.PauseTiming();
        int arr[state.range(0)];
        for(int i = 0; i < state.range(0); i++){
            arr[i] = i;
        }   
        int fail = state.range(0) + 2;
        state.ResumeTiming();

        for(int i = 0; i < state.range(0); i++){
            if(arr[i] == fail){
                break;
            }
        }
    }
    benchmark::ClobberMemory();
}
BENCHMARK(failArrayFind)->Arg(10)->Arg(100)->Arg(1000);


static void succVectorFind(benchmark::State &state){
    for(auto _ : state){
        state.PauseTiming();
        std::vector<int> vec;
        for(int i = 0; i < state.range(0); i++){
            vec.push_back(i);
        }
        int succ = state.range(0) / 2;
        state.ResumeTiming();

        std::find(vec.begin(), vec.end(), succ);
    }
    benchmark::ClobberMemory();
}
BENCHMARK(succVectorFind)->Arg(10)->Arg(100)->Arg(1000);

static void failVectorFind(benchmark::State &state){
    for(auto _ : state){
        state.PauseTiming();
        std::vector<int> vec;
        for(int i = 0; i < state.range(0); i++){
            vec.push_back(i);
        }
        int fail = state.range(0) + 2;
        state.ResumeTiming();

        std::find(vec.begin(), vec.end(), fail);
    }
    benchmark::ClobberMemory();
}
BENCHMARK(failVectorFind)->Arg(10)->Arg(100)->Arg(1000);

static void succListFind(benchmark::State &state){
    for(auto _ : state){
        state.PauseTiming();
        std::list<int> lst;  
        for(int i = 0; i < state.range(0); i++){
            lst.push_back(i);
        }  
        int succ = state.range(0) / 2;
        benchmark::ClobberMemory();
        state.ResumeTiming();

        std::find(lst.begin(), lst.end(), succ);
    }
    benchmark::ClobberMemory();
}
BENCHMARK(succListFind)->Arg(10)->Arg(100)->Arg(1000);

static void failListFind(benchmark::State &state){
    for(auto _ : state){
        state.PauseTiming();
        std::list<int> lst;  
        for(int i = 0; i < state.range(0); i++){
            lst.push_back(i);
        }  
        int fail = state.range(0) + 2;
        benchmark::ClobberMemory();
        state.ResumeTiming();

        std::find(lst.begin(), lst.end(), fail);
    }
    benchmark::ClobberMemory();
}
BENCHMARK(failListFind)->Arg(10)->Arg(100)->Arg(1000);

static void succQueueFind(benchmark::State &state){
    for(auto _ : state){
        state.PauseTiming();
        std::deque<int> q;  
        for(int i = 0; i < state.range(0); i++){
            q.push_back(i);
        }
        int succ = state.range(0) / 2;
        benchmark::ClobberMemory();
        state.ResumeTiming();

        std::find(q.begin(), q.end(), succ);        
    }
    benchmark::ClobberMemory();
}
BENCHMARK(succQueueFind)->Arg(10)->Arg(100)->Arg(1000);

static void failQueueFind(benchmark::State &state){
    for(auto _ : state){
        state.PauseTiming();
        std::deque<int> q;  
        for(int i = 0; i < state.range(0); i++){
            q.push_back(i);
        }
        int fail = state.range(0) + 2;
        benchmark::ClobberMemory();
        state.ResumeTiming();

        std::find(q.begin(), q.end(), fail); 
    }
    benchmark::ClobberMemory();
}
BENCHMARK(failQueueFind)->Arg(10)->Arg(100)->Arg(1000);

BENCHMARK_MAIN();