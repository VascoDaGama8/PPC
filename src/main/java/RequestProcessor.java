import java.io.*;
import java.net.*;
import java.util.Random;

class RequestProcessor extends Thread //for multi-threaded server
{
    private Socket socket;
    RequestProcessor(Socket socket)
    {
        this.socket=socket;
        start(); // will load the run method
    }
    public void run()
    {
        try
        {//Declaring properties and streams
            OutputStream outputStream=socket.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            InputStream inputStream=socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            StringBuffer stringBuffer;
            String response;
            String request;
            char x;
            int y = 0;
            String name;
            String gender;//getting input stream and its reader, for reading request or acknowledgement
            stringBuffer=new StringBuffer();
            while(true)
            {
                Thread.sleep(3000);
                Random r = new Random();
                x  = (char) r.nextInt(100);
                System.out.println(x);
                outputStreamWriter.write(x);
//                y++;
                if(y == 0) {
                    outputStreamWriter.write(-1);
                    break;
                }
            }
            System.out.println("End thread");
//            request=stringBuffer.toString();
//            System.out.println("Request : "+request);//parsing and extracting Request data
//            temp1=request.indexOf(",");
//            temp2=request.indexOf(",",temp1+1);
//            part1=request.substring(0,temp1);
//            part2=request.substring(temp1+1,temp2);
//            part3=request.substring(temp2+1);
//            rollNumber=Integer.parseInt(part1);
//            name=part2;
//            gender=part3;
//            System.out.println("Roll number : "+rollNumber);
//            System.out.println("Name : "+name);
//            System.out.println("Gender : "+gender);
//    // handle data//sending response
//            response="Data saved#";//get output stream and its writer, for sending response or acknowledgement
//            outputStream=socket.getOutputStream();
//            outputStreamWriter=new OutputStreamWriter(outputStream);
//            outputStreamWriter.write(response);
            outputStreamWriter.flush(); // response sent
//            System.out.println("Response sent");
            socket.close(); //terminating connection
        }catch(Exception exception)
        {
            System.out.println(exception);
        }
    }
}