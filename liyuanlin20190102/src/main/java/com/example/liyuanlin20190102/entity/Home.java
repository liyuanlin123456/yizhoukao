package com.example.liyuanlin20190102.entity;

import java.util.List;

public class Home {
    public Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data{
        public TuiJian tuijian;

        public TuiJian getTuijian() {
            return tuijian;
        }

        public void setTuiJian(TuiJian tuijian) {
            this.tuijian = tuijian;
        }

        public class TuiJian{
            public List<Tui> list;

            public List<Tui> getList() {
                return list;
            }

            public void setList(List<Tui> list) {
                this.list = list;
            }

            public class Tui{
                public int pid;
                public String images;
                public double price;
                public String title;

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }

                public String getImages() {
                    return images;
                }

                public void setImages(String images) {
                    this.images = images;
                }

                public double getPrice() {
                    return price;
                }

                public void setPrice(double price) {
                    this.price = price;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }
    }
}
