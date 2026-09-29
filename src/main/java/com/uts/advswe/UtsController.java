package com.uts.advswe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtsController {

    @Autowired
    private JohnTravoltaService johnTravoltaService;

    @Autowired
    private PersamaanKuadratService persamaanKuadratService;

    // Styling CSS Utama: Tema Burgundy Red & Split Layout
    private final String commonStyle = 
        "<link href='https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;600;700&display=swap' rel='stylesheet'>" +
        "<style>" +
        "  * { box-sizing: border-box; margin: 0; padding: 0; font-family: 'Plus Jakarta Sans', sans-serif; }" +
        "  body { background-color: #2b0812; background-image: radial-gradient(circle at top, #4a1020 0%, #1a040a 100%); min-height: 100vh; display: flex; justify-content: center; align-items: center; padding: 30px 20px; color: #333; }" +
        "  .wrapper { width: 100%; max-width: 900px; background: #ffffff; border-radius: 20px; overflow: hidden; box-shadow: 0 20px 40px rgba(0,0,0,0.4); }" +
        "  .top-banner { background: linear-gradient(135deg, #6b0d24 0%, #4a0818 100%); padding: 35px 40px; color: #ffffff; text-align: left; border-bottom: 4px solid #9e1c38; }" +
        "  .top-banner h1 { font-size: 26px; font-weight: 700; letter-spacing: -0.5px; margin-bottom: 6px; }" +
        "  .top-banner p { color: #f3ce32; font-size: 14px; font-weight: 500; text-transform: uppercase; letter-spacing: 1px; }" +
        "  .content-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 25px; padding: 35px 40px; background: #faf8f8; }" +
        "  @media (max-width: 768px) { .content-grid { grid-template-columns: 1fr; } }" +
        "  .card { background: #ffffff; border: 1px solid #f0e6e8; border-radius: 14px; padding: 25px; display: flex; flex-direction: column; justify-content: space-between; box-shadow: 0 4px 12px rgba(128, 0, 32, 0.04); transition: transform 0.2s, box-shadow 0.2s; }" +
        "  .card:hover { transform: translateY(-3px); box-shadow: 0 8px 20px rgba(128, 0, 32, 0.08); border-color: #dcb3bc; }" +
        "  .card-header { display: flex; align-items: center; gap: 12px; margin-bottom: 18px; border-bottom: 2px solid #f8ecee; padding-bottom: 12px; }" +
        "  .badge { background: #800020; color: #fff; width: 30px; height: 30px; border-radius: 50%; display: flex; align-items: center; justify-content: center; font-weight: 700; font-size: 13px; flex-shrink: 0; }" +
        "  .card h3 { color: #500014; font-size: 16px; font-weight: 700; margin: 0; line-height: 1.3; }" +
        "  .form-group { margin-bottom: 14px; }" +
        "  label { display: block; font-size: 12px; font-weight: 700; color: #665256; text-transform: uppercase; letter-spacing: 0.5px; margin-bottom: 6px; }" +
        "  input[type='number'] { width: 100%; padding: 10px 12px; font-size: 14px; border: 1.5px solid #e2d5d8; border-radius: 8px; outline: none; transition: border-color 0.2s; background: #fff; color: #2b0812; font-weight: 500; }" +
        "  input[type='number']:focus { border-color: #800020; box-shadow: 0 0 0 3px rgba(128, 0, 32, 0.12); }" +
        "  .grid-3 { display: grid; grid-template-columns: repeat(3, 1fr); gap: 10px; margin-bottom: 14px; }" +
        "  .btn-burgundy { width: 100%; padding: 12px; background: #800020; color: white; border: none; border-radius: 8px; font-weight: 600; font-size: 14px; cursor: pointer; transition: background 0.2s; margin-top: auto; letter-spacing: 0.3px; }" +
        "  .btn-burgundy:hover { background: #5c0017; }" +
        "  .result-wrapper { padding: 40px; background: #faf8f8; }" +
        "  .result-card { background: #ffffff; border-left: 5px solid #800020; padding: 25px; border-radius: 8px; box-shadow: 0 4px 15px rgba(0,0,0,0.05); color: #2b0812; font-size: 15px; line-height: 1.6; margin-bottom: 25px; }" +
        "  .btn-back { display: inline-block; padding: 10px 20px; background: #4a5568; color: white; text-decoration: none; border-radius: 8px; font-weight: 600; font-size: 13px; transition: background 0.2s; }" +
        "  .btn-back:hover { background: #2d3748; }" +
        "</style>";

    // Halaman Utama
    @GetMapping("/")
    public String home() {
        return "<html>" +
               "<head>" +
               "  <title>UTS AdvSWE - Rizki Febrian</title>" +
               commonStyle +
               "</head>" +
               "<body>" +
               "  <div class='wrapper'>" +
               "    <div class='top-banner'>" +
               "      <h1>Tugas UTS Advanced SWE</h1>" +
               "      <p>Pengembang: Rizki Febrian</p>" +
               "    </div>" +
               
               "    <div class='content-grid'>" +
               
               "      <!-- Card 1: Gaji Travolta -->" +
               "      <div class='card'>" +
               "        <div>" +
               "          <div class='card-header'>" +
               "            <span class='badge'>01</span>" +
               "            <h3>Sistem Penggajian John Travolta</h3>" +
               "          </div>" +
               "          <form action='/travolta' method='GET' id='form-travolta'>" +
               "            <div class='form-group'>" +
               "              <label for='jam'>Total Jam Kerja Per Minggu</label>" +
               "              <input type='number' id='jam' name='jam' value='52' min='0' placeholder='Masukkan jam...' required>" +
               "            </div>" +
               "          </form>" +
               "        </div>" +
               "        <button type='submit' form='form-travolta' class='btn-burgundy'>Hitung Pendapatan</button>" +
               "      </div>" +

               "      <!-- Card 2: Persamaan Kuadrat -->" +
               "      <div class='card'>" +
               "        <div>" +
               "          <div class='card-header'>" +
               "            <span class='badge'>02</span>" +
               "            <h3>Penghitung Akar Persamaan Kuadrat</h3>" +
               "          </div>" +
               "          <form action='/kuadrat' method='GET' id='form-kuadrat'>" +
               "            <div class='grid-3'>" +
               "              <div>" +
               "                <label for='a'>Koef a</label>" +
               "                <input type='number' step='any' id='a' name='a' value='1' required>" +
               "              </div>" +
               "              <div>" +
               "                <label for='b'>Koef b</label>" +
               "                <input type='number' step='any' id='b' name='b' value='-3' required>" +
               "              </div>" +
               "              <div>" +
               "                <label for='c'>Koef c</label>" +
               "                <input type='number' step='any' id='c' name='c' value='2' required>" +
               "              </div>" +
               "            </div>" +
               "          </form>" +
               "        </div>" +
               "        <button type='submit' form='form-kuadrat' class='btn-burgundy'>Analisis & Cari Akar</button>" +
               "      </div>" +

               "    </div>" +
               "  </div>" +
               "</body>" +
               "</html>";
    }

    // Endpoint Hasil Gaji
    @GetMapping("/travolta")
    public String travolta(@RequestParam(defaultValue = "0") int jam) {
        String hasil = johnTravoltaService.hitungGaji(jam);
        return "<html>" +
               "<head>" +
               "  <title>Rincian Gaji - Rizki Febrian</title>" +
               commonStyle +
               "</head>" +
               "<body>" +
               "  <div class='wrapper'>" +
               "    <div class='top-banner'>" +
               "      <h1>Rincian Gaji John Travolta</h1>" +
               "      <p>Laporan Hasil Kalkulasi Jam Kerja</p>" +
               "    </div>" +
               "    <div class='result-wrapper'>" +
               "      <div class='result-card'>" +
               "        " + hasil +
               "      </div>" +
               "      <a href='/' class='btn-back'>← Kembali ke Menu Utama</a>" +
               "    </div>" +
               "  </div>" +
               "</body>" +
               "</html>";
    }

    // Endpoint Hasil Persamaan Kuadrat
    @GetMapping("/kuadrat")
    public String kuadrat(@RequestParam(defaultValue = "0") double a,
                          @RequestParam(defaultValue = "0") double b,
                          @RequestParam(defaultValue = "0") double c) {
        String hasil = persamaanKuadratService.hitungAkar(a, b, c);
        return "<html>" +
               "<head>" +
               "  <title>Hasil Analisis - Rizki Febrian</title>" +
               commonStyle +
               "</head>" +
               "<body>" +
               "  <div class='wrapper'>" +
               "    <div class='top-banner'>" +
               "      <h1>Hasil Akar Persamaan Kuadrat</h1>" +
               "      <p>Penyelesaian Persamaan ax² + bx + c = 0</p>" +
               "    </div>" +
               "    <div class='result-wrapper'>" +
               "      <div class='result-card'>" +
               "        " + hasil +
               "      </div>" +
               "      <a href='/' class='btn-back'>← Kembali ke Menu Utama</a>" +
               "    </div>" +
               "  </div>" +
               "</body>" +
               "</html>";
    }
}