import './CatPage.css'
import React, {useState} from 'react';
import Paper from '@mui/material/Paper';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import { catsData } from './CatData';

type CatProps = {
    title: string;
    img: string;
    price: string;
    descript: string
}

type CatListProps = {
    listCats: CatProps[];
}

type PageProps = {
    logout: () => void;
}

export default function(props: PageProps){
    const [cat, setCat] = useState<CatProps | null>(null);
    return(
        <div className='app-container'>
            <div>
                <div style={{textAlign: 'center'}}>
                <p style={{fontSize: '24px', fontWeight: '600'}}>MY CAT</p>
                </div>
                <CatList listCats={catsData}/>
                <div style={{display: 'flex', justifyContent: 'center', margin: '20px 0px'}}>
                <button className='dang-xuat' onClick={() => {props.logout()}}>Đăng xuất</button>
                </div>
            </div>
        </div>
    )
}

const CatList = ({listCats}: CatListProps): JSX.Element => {
    const [cat, setCat] = useState<CatProps | null>(null);
    return(
    <Paper elevation={3} style={{width: '1000px', height: '600px', maxWidth: '95vw', marginBottom: '20px'}}>
    <div style={{display: 'flex', height: '100%'}}>
        <div style={{width: '33%', height: '100%'}}>
            <List sx={{width: '100%', height: '100%', overflow: 'auto'}}>
                {listCats.map((item, index) => {
                    return(
                        <ListItem key={index} style={{padding: 0, margin: 0}} className='item-list' onClick={() => {setCat(item)}}>
                        <div style={{display: 'flex', flexWrap: 'wrap', alignItems: 'center', width: '100%'}}>
                            <img style={{width: '50px', height: '50px', borderRadius: '25px', margin: '10px 20px'}} src={item.img}/>
                            <p style={{fontSize: '16px', fontWeight: '500'}}>{item.title}</p>
                            <div style={{width: '100%', height: '1px', backgroundColor: '#e0e0e0'}}></div>
                        </div>
                        </ListItem>
                    )
                })
                }
            </List>
        </div>
        <div style={{width: 2, height: '100%', backgroundColor: '#e0e0e0'}}>

        </div>
        <div style={{width: '66%', height: '100%', maxWidth: '66%'}}>
            {cat?
            <CatItem title={cat.title} img={cat.img} price={cat.price} descript={cat.descript}/>
            :<div style={{height: '100%', display: 'flex', alignItems:'center', justifyContent: 'center'}}>
                <h3>Chọn một chú mèo</h3>
            </div>    
                }
        </div>
    </div>
    </Paper>
    );
}

const CatItem = (props: CatProps): JSX.Element => 
    <div style={{width: '100%', height: '100%', padding: '10px 20px', boxSizing: 'border-box', overflowY: 'scroll'}}>
        <div style={{textAlign: 'center'}}>
        <h3>{props.title}</h3>
        </div>
        <div style={{display: 'flex', justifyContent: 'center', margin: '20px 0px'}}>
        <img src={props.img} style={{height: '250px', width: '500px', maxWidth: '100%'}}/>
        </div>
        <div style={{textAlign: 'justify'}}>
        <p><strong>Giá:</strong> {props.price}</p>
        <p><strong>Mô tả:</strong> {props.descript}</p>
        </div>
    </div>