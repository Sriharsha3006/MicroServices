
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic'
import {AppModule} from './app.module'

//This file is going to bootstrap our app module, but how this main.ts file is executed?
/*this is done by systemjs.config.js file (seepackages: {
app: {
    main: './main.js',
    defaultExtension: 'js'
  })
  we have added the below code in index.HTML file to load app package from systemjs.config.js file
  <script type="text/javascript">
    System.import('app').catch(function(err){console.err(err)})
  </script>
  when we say 'System.import('app')' it executes the main.ts file and does the bootstraping
*/
/*
 * To bootstrap our AppModule we need to access the bootStapModule() function.
 * This bootstropModule() function is in platformBrowserDynamic object, so we need to import this
 */
platformBrowserDynamic().bootstrapModule(AppModule)