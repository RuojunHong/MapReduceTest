import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UberReducer
 extends Reducer<Text, Text, Text, IntWritable> {

 @Override
 public void reduce(Text key, Iterable<Text> values, Context context)
  throws IOException, InterruptedException {

  int maxLength = Integer.MIN_VALUE;
  for (Text value : values) {
  	maxLength = Math.max(maxLength,value.toString().length())
  }
 context.write(key, new IntWritable(maxLength));
 }
}
