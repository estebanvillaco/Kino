package no.usn.kino.kino.dto;

import java.util.List;

public class BillettBestillingDto {
    private int visningsnr;
    private int kinosalnr;
    private List<PlassDto> plasser;

    public int getVisningsnr() {
        return visningsnr;
    }

    public void setVisningsnr(int visningsnr) {
        this.visningsnr = visningsnr;
    }

    public int getKinosalnr() {
        return kinosalnr;
    }

    public void setKinosalnr(int kinosalnr) {
        this.kinosalnr = kinosalnr;
    }

    public List<PlassDto> getPlasser() {
        return plasser;
    }

    public void setPlasser(List<PlassDto> plasser) {
        this.plasser = plasser;
    }

    public static class PlassDto {
        private int radnr;
        private int setenr;

        public int getRadnr() {
            return radnr;
        }

        public void setRadnr(int radnr) {
            this.radnr = radnr;
        }

        public int getSetenr() {
            return setenr;
        }

        public void setSetenr(int setenr) {
            this.setenr = setenr;
        }
    }
}
