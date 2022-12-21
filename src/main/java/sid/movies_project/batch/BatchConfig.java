package sid.movies_project.batch;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import sid.movies_project.model.Movie;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private ItemReader<Movie> itemReader;
    @Autowired
    private ItemProcessor<Movie,Movie> itemProcessor;
    @Autowired
    private ItemWriter<Movie> itemWriter;

    @Bean
    public Job job(){
        Step step1 = stepBuilderFactory.get("Read")
                .<Movie,Movie>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
        return jobBuilderFactory.get("Read2").start(step1).build();
    }

     @Bean
    public FlatFileItemReader<Movie> flatFileItemReader(@Value("${inputFile}") Resource inputFile){
        FlatFileItemReader<Movie> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setName("FFIR");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setResource(inputFile);
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;

    }

    @Bean
    public LineMapper lineMapper() {
        DefaultLineMapper<Movie> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("releaseDate","title","overview","popularity","vote_count","vote_average","original_language","genre","url");
        defaultLineMapper.setLineTokenizer(lineTokenizer);
        BeanWrapperFieldSetMapper<Movie> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(Movie.class);
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
        return defaultLineMapper;
    }
}
