(defn bowling-sum [x y]
  (cond
    (= "X" x) (+ 10 (bowling-sum y nil))
    (= "/" y) 10
	(nil? x) 0
	(nil? y) (Integer/valueOf x)
	:else (+ (Integer/valueOf x) (Integer/valueOf y))))

(defn get-frame-score [col]
  (let [curr (first col)
        first-ball (first (rest col))
		second-ball (second (rest col))]		
    (cond
	  (= "X" curr) (+ 10 (bowling-sum first-ball second-ball))
	  (= "/" curr) (+ 10 (bowling-sum first-ball nil))
	  (= "/" first-ball) 0
	  :else (Integer/valueOf curr))))

(defn calc-score [col]
  (cond
    (empty? col) 0
    :else (+ (get-frame-score col) (calc-score (rest col)))))

;(def score ["X" "7" "/" "4" "5" "X" "9" "/" "8" "1" "3" "5" "X" "X" "3" "4"]) ; 145
;(def score ["7" "0" "4" "0" "6" "3" "9" "0" "8" "1" "3" "1" "3" "1" "8" "1" "2" "6" "0" "1"]) ; 64
(def score ["0" "4" "5" "1" "X" "2" "4" "4" "3" "5" "0" "8" "/" "1" "2" "X" "6" "/" "4"]) ; 92
;(def score ["X" "X" "X" "X" "X" "X" "X" "X" "X" "X" "X" "X"]) ; 300

(println (calc-score score))

; 1:  0 4    ==   4
; 2:  5 1    ==   6
; 3:  X      ==  16
; 4:  2 4    ==   6
; 5:  4 3    ==   7
; 6:  5 0    ==   5
; 7:  8 /    ==  11
; 8:  1 2    ==   3
; 9:  X      ==  20
; 10: 6 / 4  ==  14
; ------------------
;                92 