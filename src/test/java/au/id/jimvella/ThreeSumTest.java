package au.id.jimvella;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

import au.id.jimvella.runner.Parameterized;
import au.id.jimvella.runner.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ThreeSumTest {
	
	static{
		System.setProperty("jub.consumers", "CONSOLE,H2");
		System.setProperty("jub.db.file", ".benchmarks");
	}
	
	@Parameters
    public static Collection<String> data() {
        return Arrays.asList(new String[]{"1Kints.txt", "2kints.txt", "4kints.txt", "8kints.txt"});
    }
	
	@Rule
	public MethodRule benchmarkRun = new BenchmarkRule();
	
	String filename;
	public ThreeSumTest(String filename){
		this.filename = filename;
	}
	
	@BenchmarkOptions(benchmarkRounds = 1, warmupRounds = 0)
	@Test
	public void simple() throws IOException{
		In in = new In(new ClassPathResource(filename).getFile().getAbsolutePath());
		
		ThreeSum.count(in.readAllInts());
	}

}
