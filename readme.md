 Prosta aplikacja implementująca jedno z rozwiązań systemów uczących się.
 Dla zadanych danych wejściowych podaje prawdopodobieństwo wystąpienia np [Sunny,Hot]
Określa poziom wsparcia dla danej decyzji oraz jej dokładność.

 Przykładowe Dane:
@attribute outlook {sunny, overcast, rainy}
@attribute temperature {hot, mild, cool}
@attribute humidity {high, normal}
@attribute windy {TRUE, FALSE}
@attribute play {yes, no}

@data
sunny,hot,high,FALSE,no
sunny,hot,high,TRUE,no
overcast,hot,high,FALSE,yes
rainy,mild,high,FALSE,yes
rainy,cool,normal,FALSE,yes
rainy,cool,normal,TRUE,no
overcast,cool,normal,TRUE,yes
sunny,mild,high,FALSE,no
sunny,cool,normal,FALSE,yes
rainy,mild,normal,FALSE,yes
sunny,mild,normal,TRUE,yes
overcast,mild,high,TRUE,yes
overcast,hot,normal,FALSE,yes
rainy,mild,high,TRUE,no

Decyzje:

[sunny, hot]
licznik dokładności: 2.0
Mianownik dokładności: 2.0
Dokładność jest spełniona i wynosi: 1.0

decyzja: no
Kontr przykład to:  overcast hot high FALSE yes 
Liczba decyzji na no wynosi 4.0
Wsparcie dla sunny wynosi 0.5
Wsparcie dla rainy wynosi 0.5
Wsparcie dla mild wynosi 0.5
Wsparcie dla cool wynosi 0.25
Wsparcie dla normal wynosi 0.25
Wsparcie dla TRUE wynosi 0.75
Maksymalne wspracie posiada atrybut TRUE i wynosi: 0.75
dokladnośc nie jest spełniona

[TRUE, sunny]
licznik dokładności: 1.0
Mianownik dokładności: 0.0
Dokładność jest spełniona i wynosi: Infinity
    overcast         hot        high       FALSE         yes
       rainy        mild        high       FALSE         yes
       rainy        cool      normal       FALSE         yes
       rainy        cool      normal        TRUE          no
    overcast        cool      normal        TRUE         yes
       sunny        mild        high       FALSE          no
       sunny        cool      normal       FALSE         yes
       rainy        mild      normal       FALSE         yes
       sunny        mild      normal        TRUE         yes
    overcast        mild        high        TRUE         yes
    overcast         hot      normal       FALSE         yes
       rainy        mild        high        TRUE          no

decyzja: yes
Kontr przykład to:  rainy cool normal TRUE no 
kontr przykład istnieje
Liczba decyzji na yes wynosi 9.0
Wsparcie dla sunny wynosi 0.2222222222222222
Wsparcie dla overcast wynosi 0.4444444444444444
Wsparcie dla hot wynosi 0.2222222222222222
Wsparcie dla mild wynosi 0.4444444444444444
Wsparcie dla high wynosi 0.3333333333333333
Wsparcie dla FALSE wynosi 0.6666666666666666
Maksymalne wspracie posiada atrybut FALSE i wynosi: 0.6666666666666666
Dokładność jest spełniona i wynosi: 0.8571428571428571
       rainy        mild        high       FALSE         yes
       rainy        cool      normal       FALSE         yes
       rainy        cool      normal        TRUE          no
    overcast        cool      normal        TRUE         yes
       sunny        mild        high       FALSE          no
       sunny        cool      normal       FALSE         yes
       rainy        mild      normal       FALSE         yes
       sunny        mild      normal        TRUE         yes
    overcast        mild        high        TRUE         yes
    overcast         hot      normal       FALSE         yes
       rainy        mild        high        TRUE          no

decyzja: yes
Kontr przykład to:  rainy cool normal TRUE no 
kontr przykład istnieje
Liczba decyzji na yes wynosi 8.0
Wsparcie dla sunny wynosi 0.25
Wsparcie dla overcast wynosi 0.375
Wsparcie dla hot wynosi 0.125
Wsparcie dla mild wynosi 0.5
Wsparcie dla high wynosi 0.25
Wsparcie dla FALSE wynosi 0.625
Maksymalne wspracie posiada atrybut FALSE i wynosi: 0.625
Dokładność jest spełniona i wynosi: 0.8333333333333334
       rainy        cool      normal       FALSE         yes
       rainy        cool      normal        TRUE          no
    overcast        cool      normal        TRUE         yes
       sunny        mild        high       FALSE          no
       sunny        cool      normal       FALSE         yes
       rainy        mild      normal       FALSE         yes
       sunny        mild      normal        TRUE         yes
    overcast        mild        high        TRUE         yes
    overcast         hot      normal       FALSE         yes
       rainy        mild        high        TRUE          no

decyzja: yes
Kontr przykład to:  rainy cool normal TRUE no 
kontr przykład istnieje
Liczba decyzji na yes wynosi 7.0
Wsparcie dla sunny wynosi 0.2857142857142857
Wsparcie dla overcast wynosi 0.42857142857142855
Wsparcie dla hot wynosi 0.14285714285714285
Wsparcie dla mild wynosi 0.42857142857142855
Wsparcie dla high wynosi 0.14285714285714285
Wsparcie dla FALSE wynosi 0.5714285714285714
Maksymalne wspracie posiada atrybut FALSE i wynosi: 0.5714285714285714
Dokładność jest spełniona i wynosi: 0.8
       rainy        cool      normal        TRUE          no
    overcast        cool      normal        TRUE         yes
       sunny        mild        high       FALSE          no
       sunny        cool      normal       FALSE         yes
       rainy        mild      normal       FALSE         yes
       sunny        mild      normal        TRUE         yes
    overcast        mild        high        TRUE         yes
    overcast         hot      normal       FALSE         yes
       rainy        mild        high        TRUE          no

decyzja: no
Kontr przykład to:  overcast cool normal TRUE yes 
kontr przykład istnieje
Liczba decyzji na no wynosi 3.0
Wsparcie dla sunny wynosi 0.3333333333333333
Wsparcie dla rainy wynosi 0.6666666666666666
Wsparcie dla mild wynosi 0.6666666666666666
Wsparcie dla high wynosi 0.6666666666666666
Wsparcie dla FALSE wynosi 0.3333333333333333
Maksymalne wspracie posiada atrybut rainy i wynosi: 0.6666666666666666
dokladnośc nie jest spełniona
Kontr przykład to:  sunny cool normal FALSE yes 
kontr przykład istnieje
Liczba decyzji na no wynosi 3.0
licznik Wsparcia 1.0
Maksymalne wspracie posiada atrybut outlook i wynosi: 0.0
Maksymalne wspracie posiada atrybut outlook i wynosi: 0.0

0
0

[rainy, outlook]
licznik dokładności: 1.0
Mianownik dokładności: 0.0
Dokładność jest spełniona i wynosi: Infinity
    overcast        cool      normal        TRUE         yes
       sunny        mild        high       FALSE          no
       sunny        cool      normal       FALSE         yes
       rainy        mild      normal       FALSE         yes
       sunny        mild      normal        TRUE         yes
    overcast        mild        high        TRUE         yes
    overcast         hot      normal       FALSE         yes
       rainy        mild        high        TRUE          no

decyzja: yes
Kontr przykład to:  sunny mild high FALSE no 
kontr przykład istnieje
Liczba decyzji na yes wynosi 6.0
Wsparcie dla overcast wynosi 0.5
Wsparcie dla rainy wynosi 0.16666666666666666
Wsparcie dla hot wynosi 0.16666666666666666
Wsparcie dla cool wynosi 0.3333333333333333
Wsparcie dla normal wynosi 0.8333333333333334
Wsparcie dla TRUE wynosi 0.5
Maksymalne wspracie posiada atrybut normal i wynosi: 0.8333333333333334
Dokładność jest spełniona i wynosi: 1.0
