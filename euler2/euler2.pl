#!/usr/bin/perl
open (F, $ARGV[0]);
$maxVal = <F>;
close(F);

$b = 1;
$c = 1;
$sum = 0;

while ($a <= $maxVal) {
  $a = $b + $c;
  $b = $c + $a;
  $c = $a + $b;
  $sum = $sum + $a;
}

printf "%d\n", ($sum - $a);
