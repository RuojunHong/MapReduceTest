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
  String str_cleaned = str[0].substring(1);//get rid of " at beginning
  String[] date = str_cleaned.split("/|\\:|\\ ");
  if (date.length>3){
	if(date[0].length()==1){
		date[0]="0"+date[0];
	}
	if(date[1].length()==1){
		date[1]="0"+date[1];
	}
	if(date[3].length()==1){
		date[3]="0"+date[3];
	}
	context.write(new Text(date[2]+date[0]+date[1]+date[3]), new IntWritable(1));
}
}
}
