import {Injectable} from '@angular/core'
import {Observable} from 'rxjs'
import 'rxjs/add/operator/map'
import {IRooms} from './room.module'
import { Http, Response, Headers, RequestOptions } from '@angular/http'

@Injectable()
export class RoomService {
    
    constructor(private http:Http){}
    
    getRoomData(url:string):Observable<IRooms[]>{
        return this.http.get(url).map((response:Response)=> {
            return response.json();
        });
    }
    
    bookARoom(url:string, room:IRooms):Observable<IRooms>{
        console.log(room)
        let headers= new Headers({'Content-Type': 'application/json'});
        let options=new RequestOptions({headers})
        return this.http.put(url,JSON.stringify(room), {headers:headers})
                        .map((response:Response)=>{
                            console.log(response.json())
                                return response.json();
                        });
    }
}