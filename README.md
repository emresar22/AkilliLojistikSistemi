# Akıllı Lojistik Sistemi

Bu proje, Nesneye Yönelik Programlama dersi için geliştirilmiş bir akıllı teslimat ve rota optimizasyonu sistemidir.

## Kullanılan Teknolojiler
* Java 25
* Maven
* JUnit 5 (Birim Testleri)

## Mimari ve Prensipler
* **SOLID Prensipleri:** SRP (Tek Sorumluluk), OCP (Açık/Kapalı), LSP (Liskov), DIP (Bağımlılıkların Ters Çevrilmesi) uygulanmıştır.
* **Tasarım Kalıpları:** Factory Pattern (Araç üretimi için) ve Strategy Pattern mantığıyla ayrıştırılmış Algoritma yapısı.
* **OOP Yapıları:** Kapsülleme, Soyutlama, Kalıtım ve Çok Biçimlilik tüm modellere entegre edilmiştir.
* **Algoritma:** Paket yükleme optimizasyonu için 0/1 Knapsack (Sırt Çantası) algoritması kullanılmıştır.

## Kurulum ve Çalıştırma
Projeyi klonladıktan sonra `Main.java` sınıfını çalıştırarak konsol arayüzüne erişebilirsiniz. Paket verileri kalıcı olarak `packages.txt` dosyasında saklanmaktadır.