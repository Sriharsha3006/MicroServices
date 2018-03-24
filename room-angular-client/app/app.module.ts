import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser'
import {RouterModule} from '@angular/router'
import {FormsModule,ReactiveFormsModule} from '@angular/forms'
import {HttpModule} from '@angular/http';

/*Components are registered into this module, this is done using declarations
 * Here EventsAppComponent is the container for all the components in our app
 * So we are going to tell our module that we use this component(EventsAppComponent) to bootstarp our module
 * In order to bootstrap this module from index.HTML file, we have to create a main.ts file, so that index.HTMl
 * file loads this main.ts file for initial bootstarping and load this module
 * Services have to be registered to this module using "providers"
 */
import {RoomAppComponent} from './room-app.component';
import {NavBarComponent} from './nav/nav-bar.component';
import {AllRoomsComponent} from './allRooms/all-rooms.component'
import {appRoutes} from './routes'
import {RoomService} from './service/room.service'
import {BookedRoomsComponent} from './bookedRooms/booked-rooms.component'
import {AvailableRoomsComponent} from './availableRooms/available-rooms.component'
import {RoomDisplayComponent} from './rooms/room-display.component'
import {BookRoomComponent} from './bookAroom/book-room.component'
import {RoomCongragulateComponent} from './bookAroom/room-congratulate.component'

@NgModule({
    imports:[BrowserModule,
             RouterModule.forRoot(appRoutes,{ useHash: true }),
             HttpModule,
             ],
    declarations:[RoomAppComponent,
                  NavBarComponent,
                  AllRoomsComponent,
                  BookedRoomsComponent,
                  AvailableRoomsComponent,
                  RoomDisplayComponent,
                  BookRoomComponent,
                  RoomCongragulateComponent],
    bootstrap:[RoomAppComponent],
    providers:[RoomService]
})
export class AppModule {}