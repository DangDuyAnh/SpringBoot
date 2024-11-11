import React, { Component } from 'react'

export default class Temp extends Component {
  render() {
    return (
        <div className='outter-container'>
            <div className="container">
                <div className='wrapper'>
                    <div className='login-bar'>
                        <div className='login-text'>
                            <LocalPhoneIcon style={{fontSize: '14px', marginTop: '2px'}}/>
                            <p style={{marginLeft: '4px'}}>(08)6680 9686 - (08)1234 6577</p>
                        </div>

                        <div className='login-text'>
                            <a>Đăng ký</a>
                            <p style={{margin: '0px 15px'}}> | </p>
                            <a>Đăng nhập</a>
                        </div>
                    </div>

                    <div className='navbar'>
                        <div className='login-bar'>
                            <FaceIcon />
                            <FaceIcon />                           
                        </div>
                        <div className='navbar-inner'>
                            <img src={Slider2} alt="Product" style={{width: '250px', height: '60px', margin: '0px 30px 0px 30px'}}/>
                            <div className='row' style={{marginRight: '50px'}}>
                                <a href='#'>Trang chủ</a>
                                <a href='#'>Giới thiệu</a>
                                <a href='#'>Sản phẩm</a>
                                <a href='#'>Dịch vụ</a>
                                <a href='#'>Tin tức</a>
                                <a href='#'>Liên hệ</a>
                                <a href='#'>Bản đồ</a>
                            </div>
                            <div className='row' >
                                <SearchIcon style={{margin: '12px', color: '#3e2723'}}/>
                                <ShoppingBasketIcon style={{margin: '12px', color: '#3e2723'}}/>
                                <p>0 sản phẩm</p>
                            </div>
                        </div>
                        <div className='dashed-line' />
                    </div>

                </div>
            </div>
        </div>
    )
  }
}
