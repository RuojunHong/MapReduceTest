import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UberReducer
 extends Reducer<Text, IntWritable, Text, IntWritable> {

 @Override
 public void reduce(Text key, Iterable<IntWritable> values, Context context)
  throws IOException, InterruptedException {
 for (IntWritable value : values) {
 context.write(new Text("new google.maps.LatLng("+key+"),,"), value);
}
}
}

