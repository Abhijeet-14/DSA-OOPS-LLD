# Notes

1. What is package.json?
    > configuration of npm for this project
2. Most Imp Package for Project?
    > Bundler - webpack, parcel etc
    > Bundler -- bundles your app -- so can be shift to prod.
3. npm install -D parcel
    > -D ? -- dev depencey -- which used in development phase
4. what is package-lock.json? why? diff?
    > p-l.json -- keep track of extact version of package
5. node_modules?
    > loaded extact package's code in this folder
    > it also pull package's depencey code
6. React CDN - takes time -- easy to manage thro npm
    > npm install react & react-dom
    > remove React CDN
7. After remove CDN -- error -- React & ReactDOM not defined
   > import React & ReactDOM in app.js
8. will it work now?
    > No, it gives error "cannot use import statement outside a module"
    > as currentlt -- in index.html --- src=App.js -- is Browser JS --
    > and Browser JS doesn't support -- import 
9. Solution?
   > define type=module in script  --  <script type="module" src="./App.js"></script>
    > run thro server - npx parcel indx.html
    > if error install "parcel-bundler" -> then run "npx parcel index.html"
10. Parcel
    > Dev Build
    > Local server
    > HMR - Hot Module Replacement
    > File Watcher Algo - written in C++
    > Faster Build -- by Caching
    > Image optimization
    > Minify files
    > Bundling
    > Compressing
    > Code spliting
    > Differntial Bundling - support all browser(old)
11. lets make compatible to Older Broswer
    > use 'browserslist"
    > "browserslist": ["last 2 chrome version", "last 2 firefox version" ]
    > learn more -- browserslist.dev

12. Congratualte --- you create your own "create-react-app"

