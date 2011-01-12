#!/usr/bin/ruby
num = File.new(ARGV[0], "r").gets.strip.to_i
prime = 2

(num % prime == 0) ? (num /= prime) : (prime += 1) while num > 1

puts prime
