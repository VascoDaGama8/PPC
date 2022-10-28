import java.io.*;
import java.net.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
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
        {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String x = "We will send you equation\n";
            String y;
            ArrayList <String> buf = new ArrayList<>();
            out.write(x);
            long time = System.currentTimeMillis();
            while (true) {
                System.out.println("n");
                out.write("1\n");
                out.flush();
                time = System.nanoTime();

                Thread.sleep(3000);
                if((y = in.readLine()) != null){
                    buf.add(y);
                    System.out.println(y);
                }
                System.out.println("k");
            }
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                if (".".equals(inputLine)) {
//                    out.println("bye");
//                    break;
//                }
//                out.println(inputLine);
//            }
//            in.close();
//            out.flush();
//            socket.close();
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }
}