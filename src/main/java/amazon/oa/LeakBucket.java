package amazon.oa;

public class LeakBucket {
    public static void main (String[] args) {
        int queriesNum,storage,output_pkt_size;
        int input_pkt_size,bucket_size,size_left;

        //initial packets in the bucket
        storage=0;

        //total no. of times bucket content is checked
        queriesNum=4;

        //total no. of packets that can
        // be accommodated in the bucket
        bucket_size=10;

        //no. of packets that enters the bucket at a time
        input_pkt_size=4;

        //no. of packets that exits the bucket at a time
        output_pkt_size=1;
        for(int i=0;i<queriesNum;i++)
        {
            size_left=bucket_size-storage; //space left

            if(input_pkt_size<=(size_left))
            {
                storage+=input_pkt_size;
                System.out.println("Buffer size= "+storage+
                        " out of bucket size= "+bucket_size);
            }
            else
            {
                System.out.println("Packet loss = "
                        +(input_pkt_size-(size_left)));

                //full size
                storage=bucket_size;

                System.out.println("Buffer size= "+storage+
                        " out of bucket size= "+bucket_size);
            }
            storage-=output_pkt_size;
        }
    }
}
