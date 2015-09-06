# boot-custom

Boot task for reloading and invoking a custom function to transform a fileset.

```clj
[mrmcc3/boot-custom "0.1.0-SNAPSHOT"]
```

### Why 

My main use case is to build html pages with hiccup. (See example)

### Usage

in build.boot
```clj
(set-env! :dependencies '[[mrmcc3/boot-custom "0.1.0-SNAPSHOT"]])
(require '[mrmcc3.boot-custom :refer [custom]])
```

then set the custom function
```clj
(task-options!
 custom {:custom-fn 'example.core/build})
```

### LICENSE

Copyright © 2015 Michael McClintock

Distributed under the Eclipse Public License, the same as Clojure.
