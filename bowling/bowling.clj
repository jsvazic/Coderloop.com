(defn create-frames [curr-frame-idx col frames]
  (let [ball-1 (first col)
        ball-2 (second col)]
    (cond
	  (empty? col) frames
	  (= 10 curr-frame-idx) (recur curr-frame-idx nil (conj frames col))
	  (= "X" ball-1) (recur (inc curr-frame-idx) (rest col) (conj frames ball-1))
	  :else (recur (inc curr-frame-idx) (doall (drop 2 col)) (conj frames (vector ball-1 ball-2))))))

(defn score-frame 
  ([cur-frame] 
    (println cur-frame)
    (cond
	  (empty? cur-frame) 0
	  (= "X" (first cur-frame)) 10
	  (= 1 (count cur-frame)) (Integer/valueOf (first cur-frame))
	  (= "/" (second cur-frame)) 10
	  :else (+ (Integer/valueOf (first cur-frame)) (Integer/valueOf (second cur-frame)))))

  ([cur-frame frames]
      (cond
	    (= "X" (first cur-frame)) (+ 10 (score-frame (second frames)))
		:else (score-frame cur-frame)
	  ))
)
	  
;(def score ["X" "7" "/" "4" "5" "X" "9" "/" "8" "1" "3" "5" "X" "X" "3" "4"]) ; 145
;(def score ["7" "0" "4" "0" "6" "3" "9" "0" "8" "1" "3" "1" "3" "1" "8" "1" "2" "6" "0" "1"]) ; 64
(def score ["0" "4" "5" "1" "X" "2" "4" "4" "3" "5" "0" "8" "/" "1" "2" "X" "6" "/" "4"]) ; 92
;(def score ["X" "X" "X" "X" "X" "X" "X" "X" "X" "X" "X" "X"]) ; 300

(def frames (create-frames 1 score []))

(println frames)
(println (score-frame (first frames) (rest frames)))

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