(defn create-frames [curr-frame col frames]
  (let [ball-1 (first col)
        ball-2 (second col)]
    (cond
	  (empty? col) frames
	  (= 10 curr-frame) (recur curr-frame nil (cons frames col))
	  (= "X" ball-1) (recur (inc curr-frame) (rest col) (cons frames ball-1))
	  :else (recur (inc curr-frame) (doall (drop 2 col)) (cons frames (vector ball-1 ball-2))))))

;(def score ["X" "7" "/" "4" "5" "X" "9" "/" "8" "1" "3" "5" "X" "X" "3" "4"]) ; 145
;(def score ["7" "0" "4" "0" "6" "3" "9" "0" "8" "1" "3" "1" "3" "1" "8" "1" "2" "6" "0" "1"]) ; 64
(def score ["0" "4" "5" "1" "X" "2" "4" "4" "3" "5" "0" "8" "/" "1" "2" "X" "6" "/" "4"]) ; 92
;(def score ["X" "X" "X" "X" "X" "X" "X" "X" "X" "X" "X" "X"]) ; 300

(println (create-frames 1 score ()))

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