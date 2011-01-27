(defn get-ball-val [ball]
  (cond
    (= ball "X") 10
    (= ball "/") 10
    :else (Integer/valueOf ball)))

(defn get-frame-score [cur-ball col]
  (let [first-ball (first (rest col))
	second-ball (first (rest (rest col)))]
    (cond
      (= cur-ball "X") (+ 10 (get-ball-val first-ball) (get-ball-val second-ball))
      (= cur-ball "/") (+ 10 (get-ball-val first-ball))
      (empty? col) 0
      :else (Integer/valueOf cur-ball))))

(defn calc-score [col]
  (cond
    (empty? col) 0
    :else (+ (get-frame-score (first col) col) (calc-score (rest col)))))

(def score ["X" "7" "/" "4" "5" "X" "9" "/" "8" "1" "3" "5" "X" "X" "3" "4"])

(println (calc-score score))