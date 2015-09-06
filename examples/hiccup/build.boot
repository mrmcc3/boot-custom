(set-env!
  :source-paths #{"src"}
  :dependencies '[[mrmcc3/boot-custom "0.1.0-SNAPSHOT"]
                  [hiccup "1.0.5"]])

(require '[mrmcc3.boot-custom :refer [custom]])

(task-options!
 custom {:custom-fn 'site/build
         :data {:hello "world"}
         :msg "Rendering hiccup..."})
