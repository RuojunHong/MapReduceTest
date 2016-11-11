import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.regex.Pattern;

public class TweetsMapper
        extends Mapper<LongWritable, Text, Text, IntWritable>{

 private static final int MISSING = 9999;

 @Override
 public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException{
  String str = value.toString();
  if (Pattern.compile(Pattern.quote("hackathon"),Pattern.CASE_INSENSITIVE).matcher(str).find()) context.write(new Text("hackathon"), new IntWritable(1));
  if (Pattern.compile(Pattern.quote("Dec"),Pattern.CASE_INSENSITIVE).matcher(str).find()) context.write(new Text("Dec"), new IntWritable(1));
  if (Pattern.compile(Pattern.quote("Chicago"),Pattern.CASE_INSENSITIVE).matcher(str).find()) context.write(new Text("Chicago"), new IntWritable(1));
  if (Pattern.compile(Pattern.quote("Java"),Pattern.CASE_INSENSITIVE).matcher(str).find()) context.write(new Text("Java"), new IntWritable(1));
  context.write(new Text("hackathon"), new IntWritable(0));
  context.write(new Text("Dec"), new IntWritable(0));
  context.write(new Text("Chicago"), new IntWritable(0));
  context.write(new Text("Java"), new IntWritable(0));
}
}
