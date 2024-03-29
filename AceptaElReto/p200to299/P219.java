package AceptaElReto.p200to299;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class P219 {

    static class Reader {

        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) {
                return;
            }
            din.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Reader s = new Reader();
        final int casos = s.nextInt();
        for (int i = 0; i < casos; i++) {
            int n = s.nextInt();
            int nPar = 0, nDec;
            for (int j = 0; j < n; j++) {
                nDec = s.nextInt();
                if (nDec % 2 == 0) {
                    nPar++;
                }
            }
            System.out.println(nPar);
        }
    }

}
