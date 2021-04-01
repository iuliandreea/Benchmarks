package App;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


public class Main {
    public static void main(String[] args) throws Exception {
        //org.openjdk.jmh.Main.main(args);
        Options opts = new OptionsBuilder()
                .include(".*.Creation.*")
                .result("Creation.csv")
                .resultFormat(ResultFormatType.CSV)
                .build();
        new Runner(opts).run();
    }
}
