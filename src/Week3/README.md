# Mayın Tarlası Oyunu
- Bu proje, Java programlama dili kullanılarak geliştirilmiş basit bir Mayın Tarlası oyunudur.
- @www.linkedin.com/in/kemalenesyalcin

## Kullanılan Teknolojiler
- Oracle OpenJDK version 21.0.2
 

## Oyun Kuralları Ve Oynanış:
- Oyun metin tabanlıdır.Mainden başlatılır.
- Oyuna başlarken oyun alanı kullanıcı tarafından belirlenir.En az 2x2 bir alanda oynanabilir.Kapalı alanlar "-" ile mayınlarsa "*" ile gösterilmektedir.
- Kullanıcının seçtiği alanda mayın yok ise çevresindeki kareler kontrol edilir ve kullanıcıya çevresinde kaç adet mayın olduğu gösterilir.
- Kullanıcı hiç bir mayına basmadan tüm noktaları açarak oyunu kazanabilir.

## Kaybetme Senaryosu

``````
Mayın Tarlası Oyuna Hoşgeldiniz !
- - - 
- - - 
- - -
Satır Giriniz : 0
Sütun Giriniz : 1
===========================
- 2 -
- - -
- - -
Satır Giriniz : 2
Sütun Giriniz : 0
===========================
- 2 -
- - -
0 - -
Satır Giriniz : 0
Sütun Giriniz : 2
===========================
- 2 1
- - -
0 - -
Satır Giriniz : 0
Sütun Giriniz : 0
Game Over!!
===========================
``````
# Kazanma Senaryosu

``````

Mayın Tarlası Oyuna Hoşgeldiniz ! 
- - - 
- - - 
- - - 
Satır Giriniz : 0 
Sütun Giriniz : 0 
=========================== 
1 - - 
- - - 
- - - 
Satır Giriniz : 0 
Sütun Giriniz : 1 
=========================== 
1 1 - 
- - - 
- - - 
Satır Giriniz : 0 
Sütun Giriniz : 2 
=========================== 
1 1 1 
- - - 
- - - 
Satır Giriniz : 1 
Sütun Giriniz : 0 
=========================== 
1 1 1 
2 - - 
- - - 
Satır Giriniz : 2 
Sütun Giriniz : 0 
=========================== 
1 1 1 
2 - - 
2 - - 
Satır Giriniz : 1 
Sütun Giriniz : 2 
=========================== 
1 1 1 
2 - 2 
2 - - 
Satır Giriniz : 2 
Sütun Giriniz : 2 
Oyunu Kazandınız ! 
1 1 1 
2 - 2 
2 - 2 
===========================
``````