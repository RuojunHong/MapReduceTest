import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.regex.Pattern;

public class UberMapper
        extends Mapper<LongWritable, Text, Text, IntWritable>{

 private static final int MISSING = 9999;

 @Override
 public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException{
  String[] str = value.toString().split(",");
  String str_cleaned = str[1];
  String[] date = str_cleaned.split("-|\\:|\\ ");
  if (date.length>3){
	context.write(new Text(date[0]+date[1]+date[2]+date[3]), new IntWritable(1));
}
}
}
