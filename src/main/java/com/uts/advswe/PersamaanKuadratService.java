package com.uts.advswe;

import org.springframework.stereotype.Service;

@Service
public class PersamaanKuadratService {

    public String hitungAkar(double a, double b, double c) {
        StringBuilder html = new StringBuilder();
        html.append("<h3>=== RUMUS PERSAMAAN KUADRAT ===</h3>");
        
        if (a == 0) {
            return html.append("Nilai 'a' tidak boleh 0 karena bukan persamaan kuadrat.").toString();
        }

        html.append("Persamaan: ").append(a).append("x^2 + ").append(b).append("x + ").append(c).append(" = 0<br>");
        double d = (b * b) - (4 * a * c);
        html.append("Diskriminan (D) = ").append(d).append("<br><br>");

        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            html.append("<strong>Hasil: Memiliki 2 akar real berbeda.</strong><br>");
            html.append("x1 = ").append(x1).append(" | x2 = ").append(x2);
        } else if (d == 0) {
            double x = -b / (2 * a);
            html.append("<strong>Hasil: Memiliki 1 akar real (akar kembar).</strong><br>");
            html.append("x1 = x2 = ").append(x);
        } else {
            html.append("<strong>Hasil: Akar imajiner (tidak memiliki akar real).</strong>");
        }
        
        return html.toString();
    }
}