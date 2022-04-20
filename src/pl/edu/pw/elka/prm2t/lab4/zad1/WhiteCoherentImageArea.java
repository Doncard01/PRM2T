package pl.edu.pw.elka.prm2t.lab4.zad1;

import pl.edu.pw.elka.prm2t.PRM2TUtil; //funkcja readImage

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pl.edu.pw.elka.prm2t.PRM2TUtil.prn;

/**
 * To find all white coherent areas in the binary image.
 */
public class WhiteCoherentImageArea {
    private final String pathName;

    // there will be whiteCoherentImageAreas.size() white coherent areas in the image
    // and n-th area has whiteCoherentImageAreas.get(n).getInt() pixels
    private final List<Integer> whiteCoherentImageAreas = new ArrayList<>();

    private class Area {
        int whites;
        List<Point> neighbours = new ArrayList<>();
    }

    WhiteCoherentImageArea(String pathName) throws IOException {
        this.pathName = pathName;
        final int[][] img = PRM2TUtil.readImage(pathName);

        for(int i=0; i<img.length; i++) {
            for (int j=0; j<img[i].length; j++) {
                if(img[i][j]==0) {
                    continue;
                }
                else {
                    Area temp = new Area();
                    temp.whites++;
                    if (img[i][j-1] != 0) {
                        temp.neighbours.add(new Point(i, j-1));
                    }
                    if (img[i][j+1] != 0) {
                        temp.neighbours.add(new Point(i, j+1));
                    }
                    if (img[i+1][j+1] != 0) {
                        temp.neighbours.add(new Point(i+1, j+1));
                    }
                    if (img[i+1][j-1] != 0) {
                        temp.neighbours.add(new Point(i+1, j-1));
                    }
                    if (img[i+1][j] != 0) {
                        temp.neighbours.add(new Point(i+1, j));
                    }
                    if (img[i-1][j+1] != 0) {
                        temp.neighbours.add(new Point(i-1, j+1));
                    }
                    if (img[i-1][j-1] != 0) {
                        temp.neighbours.add(new Point(i-1, j-1));
                    }
                    if (img[i-1][j] != 0) {
                        temp.neighbours.add(new Point(i-1, j));
                    }


                    img[i][j] = 0;
                }
            }
        }


        System.out.println(img.length + ", " + img[0].length);
    }

    /**
     * @return String describing white coherent areas found in the image; string is ready to present to the end user.
     */
    public String asString() {
        StringBuilder sb = new StringBuilder("There ");
        sb.append(switch (whiteCoherentImageAreas.size()) {
            case 0 -> "is no";
            case 1 -> "is one";
            default -> String.format("are %d", whiteCoherentImageAreas.size());
        });
        sb.append(" coherent area").append(whiteCoherentImageAreas.size() > 1 ? "s" : "");
        sb.append(" in the image file ").append(pathName);
        if (whiteCoherentImageAreas.size() == 1) {
            sb.append(" of size ").append(whiteCoherentImageAreas.get(0));
            return sb.toString();
        }
        if (whiteCoherentImageAreas.size() < 2) {
            return sb.toString();
        }
        sb.append(String.format("%nCoherent areas sizes: "));
        for (Integer areaSize : whiteCoherentImageAreas) {
            sb.append(areaSize).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public String toString() {
        return asString();
    }

    public static void main(String[] args) throws IOException {
        //final String pathName = args[0];
        final String pathName = "resource/oneWhiteArea.png";
        try {
            prn(new WhiteCoherentImageArea(pathName).asString());
        } catch (IOException ioe) {
            prn("Error reading image file %s (%s)", pathName, ioe);
        }
    }
}
