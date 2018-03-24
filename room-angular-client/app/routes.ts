import {Routes} from '@angular/router'
import {AllRoomsComponent} from './allRooms/all-rooms.component'
import {BookedRoomsComponent} from './bookedRooms/booked-rooms.component'
import {AvailableRoomsComponent} from './availableRooms/available-rooms.component'
import {BookRoomComponent} from './bookAroom/book-room.component'
import {RoomCongragulateComponent} from './bookAroom/room-congratulate.component'

export const appRoutes:Routes = [
    {path:'allrooms', component: AllRoomsComponent},
    {path:'bookedrooms', component:BookedRoomsComponent},
    {path:'availablerooms', component:AvailableRoomsComponent},
    {path:'bookaroom/:roomNumber', component: BookRoomComponent},
    {path:'congratulations', component:RoomCongragulateComponent},
    {path:'', redirectTo:'/allrooms', pathMatch:'full'}
]