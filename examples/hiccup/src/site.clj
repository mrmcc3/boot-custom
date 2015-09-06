(ns site
  (:require [mrmcc3.boot-custom :refer [spit-to]]
            [hiccup.page :refer [html5]]))

(defn index-page [{:keys [hello]}]
  (html5 {:lang "en"}
         [:head
          [:meta {:charset "utf-8"}]
          [:body
           [:h1 (str "hello " hello)]]]))

(defn build [fs tmp data]
  (spit-to tmp "index.html" (index-page data)))
