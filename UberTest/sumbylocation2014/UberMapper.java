import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UberMapper
        extends Mapper<LongWritable, Text, Text, IntWritable>{

 private static final int MISSING = 9999;

 @Override
 public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException{
  String[] str = value.toString().split(",");
  try{
  	String lat = String.format("%.6g", Float.valueOf(str[1]));
  	String lon = String.format("%.6g", Float.valueOf(str[2]));
  	context.write(new Text(lon+lat), new IntWritable(1));
  }
  catch (Exception e){
  }
}
}
