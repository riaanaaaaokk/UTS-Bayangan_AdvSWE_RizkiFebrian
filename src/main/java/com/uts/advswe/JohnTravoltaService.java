package com.uts.advswe;

import org.springframework.stereotype.Service;

@Service
public class JohnTravoltaService {

    public String hitungGaji(int jamKerja) {
        int rateNormal = 15000;
        int pengeluaran = 600000;
        int gajiTotal;

        if (jamKerja <= 40) {
            gajiTotal = jamKerja * rateNormal;
        } else {
            int jamLembur = jamKerja - 40;
            gajiTotal = (40 * rateNormal) + (int)(jamLembur * rateNormal * 1.5);
        }

        StringBuilder html = new StringBuilder();
        html.append("<h3>=== ALGORITMA JOHN TRAVOLTA ===</h3>");
        html.append("Jam Kerja       : ").append(jamKerja).append(" jam<br>");
        html.append("Pemasukan       : Rp ").append(gajiTotal).append("<br>");
        html.append("Pengeluaran     : Rp ").append(pengeluaran).append("<br><br>");

        if (gajiTotal > pengeluaran) {
            html.append("<strong>Status          : Bisa menabung</strong><br>");
            html.append("Total Tabungan  : Rp ").append(gajiTotal - pengeluaran);
        } else if (gajiTotal == pengeluaran) {
            html.append("<strong>Status          : Tidak bisa menabung</strong>");
        } else {
            html.append("<strong>Status          : Cari tambahan</strong>");
        }
        
        return html.toString();
    }
}