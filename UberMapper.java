import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.regex.Pattern;

public class UberMapper
        extends Mapper<LongWritable, Text, Text, Text>{

 private static final int MISSING = 9999;

 @Override
 public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException{
  String[] str = value.toString().split(",");
  context.write(new Text("date"), new Text(str[0]));
  context.write(new Text("lat"), new Text(str[1]));
  context.write(new Text("lon"), new Text(str[2]));
  context.write(new Text("base"), new Text(str[3]));
}
}
