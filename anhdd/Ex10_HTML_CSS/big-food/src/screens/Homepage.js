import React, {useState, useEffect, useRef} from 'react'
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import WatchLaterIcon from '@mui/icons-material/WatchLater';
import EmailIcon from '@mui/icons-material/Email';
import CallIcon from '@mui/icons-material/Call';
import SearchIcon from '@mui/icons-material/Search';
import ShoppingBasketIcon from '@mui/icons-material/ShoppingBasket';
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';

import './Homepage.css'
import Slider1 from '../assets/Slider + banner/slider-1.jpg';
import Banner3 from '../assets/Slider + banner/banner-3.jpg';
import Banner4 from '../assets/Slider + banner/banner-4.jpg';
import { ArrowLeft, NextPlan } from '@mui/icons-material';

export default function Homepage(props) {
    const [width, setWindowWidth] = useState(0);
    const ref = useRef(null);
    const [widthCard, setWidthCard] = useState(0);
    const [index, setIndex] = useState(0);

    useEffect(() => {
        updateDimensions();
        window.addEventListener('resize', updateDimensions);
        return () => window.removeEventListener('resize', updateDimensions);
        }, []);

    const updateDimensions = () => {
    const width = window.innerWidth;
    setWindowWidth(width);
    };

    useEffect(() => {
        console.log('width', ref.current ? ref.current.offsetWidth : 0);
        setWidthCard(ref.current.offsetWidth)
      }, [ref.current]);

    const next = () => {
        setWidthCard(ref.current.offsetWidth);
        setIndex(index+1);
        console.log(widthCard);
    }

    const prev = () => {
        setWidthCard(ref.current.offsetWidth);
        setIndex(index-1);
    }

    return (
        <>
        <div className='top-header'>
            <div className='bg-topbar'>
                <div style={{width: '1170px', display: 'flex', padding: '22px 0px', flexWrap: 'wrap', justifyContent: 'space-between', alignItems: 'center'}}>
                    <div>
                        <span style={{fontSize: '14px'}}>Chào mừng bạn đến với bigFood!</span>
                    </div>

                    <div >
                        <ul className='list-menu'>
                            <li><a href='#'>Trang chủ</a></li>
                            <li><a href='#'>Giới thiệu</a></li>
                            <li><a href='#'>Sản phẩm</a></li>
                            <li><a href='#'>Khuyến mãi</a></li>
                            <li><a href='#'>Tin tức</a></li>
                            <li><a href='#'>Liên hệ</a></li>
                            <li className='account'>
                                <div style={{display: 'flex', alignItems: 'center'}}>
                                    <a href='#'>Tài khoản</a>
                                    <KeyboardArrowDownIcon style={{marginLeft: '5px', padding: 0, cursor: 'pointer'}}/>
                                </div>
                                </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div style={{display: 'flex', justifyContent: 'center', padding: '45px 0px'}}>
                <div style={{width: '1170px', display: 'flex', flexWrap: 'wrap', justifyContent: 'space-between', alignItems: 'center'}}>
                    <img src="https://bizweb.dktcdn.net/100/053/643/themes/877493/assets/logo.jpg?1663747576101" style={{marginBottom: '20px'}}/>
                    <div style={{display: 'flex', flexWrap: 'wrap'}}>
                        <div style={{display: 'flex', margin: '0px 30px 10px 0px'}}>
                            <div className='icon-holder'>
                                <WatchLaterIcon className='icon'/>
                            </div>
                            <div className='icon-text'>
                                <p>OPEN:</p>
                                <p>8 AM - 10 PM</p>
                            </div>
                        </div>

                        <div style={{display: 'flex', margin: '0px 30px 10px 0px'}}>
                            <div className='icon-holder'>
                                <EmailIcon className='icon'/>
                            </div>

                            <div className='icon-text'>
                                <p>EMAIL</p>
                                <p>support@sapo.vn</p>
                            </div>
                        </div>

                        <div style={{display: 'flex'}}>
                            <div className='icon-holder'>
                                <CallIcon className='icon'/>
                            </div>
                            <div className='icon-text'>
                                <p>HOTLINE</p>
                                <p>19006750</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div className="bg-topbar2">
                <div style={{width: '1170px', display: 'flex', flexWrap: 'wrap', justifyContent: 'space-between', alignItems: 'center', paddingBottom: '30px'}}>

                <div>
                    <ul className='list-menu list2'>
                        <li><a href='#' style={{color: '#f2B94C'}}>Trang chủ</a></li>
                        <li><a href='#'>Giới thiệu</a></li>
                        <li>
                            <div style={{display: 'flex', alignItems: 'center'}} className='product-contain'>
                                <a href='#'>SẢN PHẨM</a>
                                <KeyboardArrowDownIcon style={{marginLeft: '5px', padding: 0, cursor: 'pointer'}} className='product-icon'/>
                            </div>
                        </li>
                        <li><a href='#'>Khuyến mãi</a></li>
                        <li><a href='#'>Tin tức</a></li>
                        <li><a href='#'>Liên hệ</a></li>
                    </ul>
                </div>

                    <div style={{display: 'flex', flexWrap: 'wrap'}}>
                        <SearchIcon style={{fontSize: '28px', fontWeight: '900', margin: '0px 12px'}}/>
                        <div style={{margin: '0px 12px', position: 'relative'}}>
                            <ShoppingBasketIcon style={{fontSize: '28px', fontWeight: '900'}}/>
                            <span className='text-icon'>0</span>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div style={{display: 'flex', justifyContent: 'center'}}>
            <img src={Slider1} style={{maxWidth: '100%'}} height={650}/>
        </div>

        <div style={{display: 'flex', justifyContent: 'center'}}>
            <div style={{width: '1170px', display: 'flex', flexWrap: 'wrap', justifyContent: 'space-between'}}>
                <Grid container style={{margin: '30px 0px'}}>
                    <Grid 
                    item 
                    lg={4} md={4} sm={12} xs={12}
                    >
                        <div className="hover-effect">
                            <div style={{width: '360px', height: '360px', maxWidth: '88vw', backgroundColor: 'pink', position: 'relative'}}>
                                <a href='#' className="bad-romance">
                                <img src={Banner3} style={{width: '100%', height: '100%', maxWidth: '100%'}}/>
                                </a>
                            </div>
                        </div>
                    </Grid>

                    <Grid item lg={8} md={8} xs={12} sm={12}>
                        <div className="hover-effect">
                        <div style={{width: '750px', height: '360px', maxWidth: '88vw', backgroundColor: 'pink', position: 'relative'}}>
                                <a href='#' className="bad-romance">
                                <img src={Banner4} style={{width: '100%', height: '100%', maxWidth: '100%'}}/>
                                </a>
                            </div>
                        </div>
                    </Grid>
                </Grid>
            </div>
        </div>

        <div style={{display: 'flex', justifyContent: 'center'}}>
            <div style={{width: '1170px', display: 'flex', flexWrap: 'wrap', justifyContent: 'space-between'}}>
                <Grid container direction="row-reverse" justifyContent="center">
                    <Grid lg={9} md={9} xs={12} sm={12} style={{padding: '0px 15px'}}>
                        <Box>
                            <div className='aside-title' style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center'}}>
                                <h2 className='title-head'>
                                    <span>Sản phẩm nổi bật</span>
                                </h2>
                                
                                <div style={{display: 'flex', alignItems: 'center', marginBottom: '2px', paddingRight: '5px'}}>
                                <ArrowBackIcon className={(index === 0)?'icon-homepage btn-disable':'icon-homepage'} onClick={prev}/>
                                <ArrowForwardIcon className={(index === 2)?'icon-homepage btn-disable':'icon-homepage'} onClick={next}/>
                                </div>
                            </div>

                            <div className='train'>
                                <div className='line' style={{transform: `translateX(${-1 * index * widthCard}px)`, transition: 'transform 0.4s ease-in-out' }}>

                                    <div ref={ref} className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/1.jpg?v=1454064638327" className='image-card'/>
                                        <div className='card-text'>
                                        <p>340.000₫</p>
                                        <p>Pizza nhân bò phô mai</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/112.jpg?v=1454040113190" className='image-card'/>
                                        <div className='card-text'>
                                        <p>234.000₫</p>
                                        <p>Pizza gà ớt xanh</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/113.jpg?v=1454040266683" className='image-card'/>
                                        <div className='card-text'>
                                        <p>222.000₫</p>
                                        <p>Pizza hải sản xúc xích</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/3.jpg?v=1454127534427" className='image-card'/>
                                        <div className='card-text'>
                                        <p>50.000₫</p>
                                        <p>Bánh Torrijia</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/8.jpg?v=1454127353000" className='image-card'/>
                                        <div className='card-text'>
                                        <p>150.000₫</p>
                                        <p>Bánh mứt kem</p>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div className='image-effect'>
                                <a href='#'>
                                    <img className='image-effect-img' src='//bizweb.dktcdn.net/100/053/643/themes/877493/assets/mid-banner.jpg?1663747576101'/>
                                </a>
                            </div>

                            <div className='aside-title' style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center'}}>
                                <h2 className='title-head'>
                                    <span>Sản phẩm mới</span>
                                </h2>
                                
                            </div>

                            <div className='train'>
                                <div className='line'>

                                    <div ref={ref} className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/1.jpg?v=1454064638327" className='image-card'/>
                                        <div className='card-text'>
                                        <p>340.000₫</p>
                                        <p>Pizza nhân bò phô mai</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/112.jpg?v=1454040113190" className='image-card'/>
                                        <div className='card-text'>
                                        <p>234.000₫</p>
                                        <p>Pizza gà ớt xanh</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/113.jpg?v=1454040266683" className='image-card'/>
                                        <div className='card-text'>
                                        <p>222.000₫</p>
                                        <p>Pizza hải sản xúc xích</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/3.jpg?v=1454127534427" className='image-card'/>
                                        <div className='card-text'>
                                        <p>50.000₫</p>
                                        <p>Bánh Torrijia</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/8.jpg?v=1454127353000" className='image-card'/>
                                        <div className='card-text'>
                                        <p>150.000₫</p>
                                        <p>Bánh mứt kem</p>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div className='aside-title' style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center'}}>
                                <h2 className='title-head'>
                                    <span>BÁN CHẠY TRONG TUẦN</span>
                                </h2>
                                
                            </div>

                            <div className='train'>
                                <div className='line'>

                                    <div ref={ref} className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/1.jpg?v=1454064638327" className='image-card'/>
                                        <div className='card-text'>
                                        <p>340.000₫</p>
                                        <p>Pizza nhân bò phô mai</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/112.jpg?v=1454040113190" className='image-card'/>
                                        <div className='card-text'>
                                        <p>234.000₫</p>
                                        <p>Pizza gà ớt xanh</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/113.jpg?v=1454040266683" className='image-card'/>
                                        <div className='card-text'>
                                        <p>222.000₫</p>
                                        <p>Pizza hải sản xúc xích</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/3.jpg?v=1454127534427" className='image-card'/>
                                        <div className='card-text'>
                                        <p>50.000₫</p>
                                        <p>Bánh Torrijia</p>
                                        </div>
                                    </div>

                                    <div className='card' style={{width: (width<800)?'100%':'33.33%'}}>
                                        <img src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/8.jpg?v=1454127353000" className='image-card'/>
                                        <div className='card-text'>
                                        <p>150.000₫</p>
                                        <p>Bánh mứt kem</p>
                                        </div>
                                    </div>

                                </div>
                            </div>

                        </Box>
                    </Grid>

                    <Grid ld={3} md={3} xs={12} sm={12}>
                        <Box style={{margin: '0px 15px 44px 15px'}}>
                            <div className='aside-title'>
                                <h2 className='title-head'>
                                    <span>Danh mục sản phẩm</span>
                                </h2>
                            </div>

                            <ul className='product-list'>
                                <li><a>Sản phẩm mới</a></li>
                                <li><a>Sản phẩm khuyến mãi</a></li>
                                <li><a>Sản phẩm nổi bật</a></li>
                                <li><a>Pizza</a></li>
                                <li><a>Bánh ngọt</a></li>
                                <li><a>Bánh kem</a></li>
                                <li><a>Đồ ăn nhẹ</a></li>
                            </ul>
                        </Box>

                        <Box style={{margin: '0px 15px'}}>
                            <div className='aside-title'>
                                <h2 className='title-head'>
                                    <span>SẢN PHẨM BÁN CHẠY</span>
                                </h2>
                            </div>
                            
                            <div>
                                <div className='item-product-card' style={{paddingTop: 0}}>
                                    <img width={70} hegith={70} src="https://bizweb.dktcdn.net/thumb/large/100/053/643/products/1.jpg?v=1454064638327" style={{marginRight: '10px'}}/>
                                    <div>
                                        <p>Pizza nhân bò phô mai</p>
                                        <p>340.000₫</p>
                                    </div>
                                </div>
                                <div className='item-product-card'>
                                    <img width={70} hegith={70} src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/112.jpg?v=1454040113190" style={{marginRight: '10px'}}/>
                                    <div>
                                        <p>Pizza gà ớt xanh</p>
                                        <p><span style={{marginRight: '12px'}}>234.000₫</span><span className='old-price'>267.000₫</span></p>
                                    </div>
                                </div>

                                <div className='item-product-card' style={{paddingTop: 0}}>
                                    <img width={70} hegith={70} src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/113.jpg?v=1454040266683" style={{marginRight: '10px'}}/>
                                    <div>
                                        <p>Pizza hải sản xúc xích</p>
                                        <p>340.000₫</p>
                                    </div>
                                </div>

                                <div className='item-product-card' style={{borderBottom: 'none'}}>
                                    <img width={70} hegith={70} src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/3.jpg?v=1454127534427" style={{marginRight: '10px'}}/>
                                    <div>
                                        <p>Bánh Torrija</p>
                                        <p><span style={{marginRight: '12px'}}>50.000₫</span><span className='old-price'>60.000₫</span></p>
                                    </div>
                                </div>
                            </div>
                        </Box>

                        <Box style={{margin: '10px 15px'}}>
                            <div className='aside-title'>
                                <h2 className='title-head'>
                                    <span>SẢN PHẨM KHUYẾN MẠI</span>
                                </h2>
                            </div>
                            
                            <div>
                                <div className='item-product-card' style={{paddingTop: 0}}>
                                    <img width={70} hegith={70} src="https://bizweb.dktcdn.net/thumb/large/100/053/643/products/1.jpg?v=1454064638327" style={{marginRight: '10px'}}/>
                                    <div>
                                        <p>Pizza nhân bò phô mai</p>
                                        <p>340.000₫</p>
                                    </div>
                                </div>
                                <div className='item-product-card'>
                                    <img width={70} hegith={70} src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/112.jpg?v=1454040113190" style={{marginRight: '10px'}}/>
                                    <div>
                                        <p>Pizza gà ớt xanh</p>
                                        <p><span style={{marginRight: '12px'}}>234.000₫</span><span className='old-price'>267.000₫</span></p>
                                    </div>
                                </div>

                                <div className='item-product-card' style={{paddingTop: 0}}>
                                    <img width={70} hegith={70} src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/113.jpg?v=1454040266683" style={{marginRight: '10px'}}/>
                                    <div>
                                        <p>Pizza hải sản xúc xích</p>
                                        <p>340.000₫</p>
                                    </div>
                                </div>

                                <div className='item-product-card' style={{borderBottom: 'none'}}>
                                    <img width={70} hegith={70} src="//bizweb.dktcdn.net/thumb/large/100/053/643/products/3.jpg?v=1454127534427" style={{marginRight: '10px'}}/>
                                    <div>
                                        <p>Bánh Torrija</p>
                                        <p><span style={{marginRight: '12px'}}>50.000₫</span><span className='old-price'>60.000₫</span></p>
                                    </div>
                                </div>
                            </div>
                        </Box>
                    </Grid>
                </Grid>
            </div>          
        </div>

        <div style={{backgroundColor: '#f8f1e4', display: 'flex', justifyContent: 'center'}}>
            <div style={{width: '1170px', display: 'flex', padding: '22px 20px', flexWrap: 'wrap', justifyContent: 'space-between', alignItems: 'center'}}>
                <Grid container>
                    <Grid item lg={2.2} md={2.2} xs={12} className='grid-text'>
                        <p>VỀ CHÚNG TÔI</p>
                        <p>Trang chủ</p>
                        <p>Giới thiệu</p>
                        <p>Sản phẩm</p>
                        <p>Khuyến mãi</p>
                        <p>Tin tức</p>
                        <p>Liên hệ</p>
                    </Grid>
                    <Grid item lg={2.2} md={2.2} xs={12} className='grid-text'>
                        <p>ĐIỀU KHOẢN</p>
                        <p>Trang chủ</p>
                        <p>Giới thiệu</p>
                        <p>Sản phẩm</p>
                        <p>Khuyến mãi</p>
                        <p>Tin tức</p>
                        <p>Liên hệ</p>
                    </Grid>
                    <Grid item lg={2.2} md={2.2} xs={12} className='grid-text'>
                        <p>HƯỚNG DẪN</p>
                        <p>Trang chủ</p>
                        <p>Giới thiệu</p>
                        <p>Sản phẩm</p>
                        <p>Khuyến mãi</p>
                        <p>Tin tức</p>
                        <p>Liên hệ</p>
                    </Grid>
                    <Grid item lg={2.2} md={2.2} xs={12} className='grid-text'>
                        <p>CHÍNH SÁCH</p>
                        <p>Trang chủ</p>
                        <p>Giới thiệu</p>
                        <p>Sản phẩm</p>
                        <p>Khuyến mãi</p>
                        <p>Tin tức</p>
                        <p>Liên hệ</p>
                    </Grid>
                    <Grid item lg md xs={12} className='grid-text-2'>
                        <p>ĐĂNG KÝ NHẬN TIN</p>
                        <p>Đăng ký nhận thông tin ưu đãi cùng với khuyến mãi khủng từ Big Food</p>

                        <div className="search-bar">
                            <input type="email" placeholder="Email của bạn" name="EMAIL" id="mail"/>
                            <button className="button_subscribe subscribe" name="subscribe" id="subscribe"><i className="fas fa-paper-plane" /></button>
                        </div>

                        <div className='icon-row'>
                            <a href='#'>
                                <i className='fab fa-facebook-f'></i>
                            </a>

                            <a href='#' style={{background: '#55ACEE'}}>
                                <i className='fab fa-twitter'></i>
                            </a>

                            <a href='#' style={{background: '#dd4b39'}}>
                                <i className='fab fa-google'></i>
                            </a>

                            <a href='#' style={{background: '#FE0000'}}>
                                <i className='fab fa-youtube'></i>
                            </a>
                        </div>
                    </Grid>                    
                </Grid>
                <div style={{width: '100%', textAlign: 'center', margin: '40px 0px', color: '#603913'}}>
                    <p style={{fontWeight: '700', fontSize: '18px'}}>CỬA HÀNG BÁNH BIGFOOD</p>
                    <p style={{margin: '2px 0px', padding: 0}}>Big Food:Tầng 6, 266 Đội Cấn, Hà Nội,</p>
                    <p style={{margin: '2px 0px', padding: 0}}>Điện thoại: 1900 6750 Email: support@sapo.vn</p>
                </div>
                <div style={{display: 'flex', flexWrap: 'wrap', justifyContent: 'space-between', width: '100%', alignItems: 'center', overflow: 'hidden'}}>
                    <p>© Bản quyền thuộc về Avent Team | Cung cấp bởi Sapo</p>
                    <img src="//bizweb.dktcdn.net/100/053/643/themes/877493/assets/payment.jpg?1663747576101" style={{width: '260px' ,height: '30px', maxWidth: '80vw'}}/>
                </div>
            </div>
        </div>
        </>
    );
}
