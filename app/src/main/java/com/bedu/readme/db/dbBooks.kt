package db

import models.Book
import models.countBook
import models.listBook

fun createDBBooks(){
    if (listBook[0] == null){
        listBook[countBook]= Book(countBook +1,"Drácula","Bram Stoker","Terror",450.24,10,false,0, "https://www.popularlibros.com/imagenes_grandes/9788468/978846833198.JPG")
        listBook[countBook]= Book(countBook +1,"Frankesnstein","Mary Shelley","Terror",350.15,10,false,0, "https://th.bing.com/th/id/OIP.3H2DW3X-Tcu1-mXxLjzeHwHaLH?pid=ImgDet&rs=1")
        listBook[countBook]= Book(countBook +1,"Misery","Stephen King","Terror",420.3,10,true,0, "https://th.bing.com/th/id/OIP.zuxIU-kn3_qiE1sfcf8ghwHaLQ?pid=ImgDet&rs=1")
        listBook[countBook]= Book(countBook +1,"Carrie","Stephen King","Terror",350.5,10,false,0,"https://th.bing.com/th/id/OIP.DyaZtG-6xd1qh1K-CSYG6wHaL4?pid=ImgDet&rs=1")
        listBook[countBook]= Book(countBook +1,"El gato Negro","Edgar Allan Poe","Terror",420.2,10,true,0,"https://imagessl6.casadellibro.com/a/l/t0/66/9782380373066.jpg")
        listBook[countBook]= Book(countBook +1,"Vuelta de tuerca","Henry James","Terror",380.359,10,false,0, "https://imagessl4.casadellibro.com/a/l/t0/84/9786074555684.jpg")
        listBook[countBook]= Book(countBook +1,"El fantasma de la ópera","Gastón Leroux","Terror",374.386,10,false,0, "https://th.bing.com/th/id/OIP.6ONyGjeP_kxcRorp1S3SOAHaLu?pid=ImgDet&rs=1")

        listBook[countBook]= Book(countBook +1,"El exorcista","William Peter Blatty","Terror",368.413,10,false,0, "https://th.bing.com/th/id/OIP.-Rg8NF2IrFlGnpHo6lt_twHaLq?pid=ImgDet&rs=1")
        listBook[countBook]= Book(countBook +1,"Entrevista con el vampiro","Anne Rice","Terror",362.44,10,true,0, "https://th.bing.com/th/id/OIP.QCWOcWVeFvvZto1JWoEPJgAAAA?pid=ImgDet&rs=1")
        listBook[countBook]= Book(countBook +1,"Cementerio de animales","Stephen King","Terror",356.467,10,false,0, "https://th.bing.com/th/id/OIP._xDn9lyxQUq4VSKdigZqZwHaLQ?pid=ImgDet&rs=1")
        listBook[countBook]= Book(countBook +1,"El marciano","Andy Weir","Ciencia Ficción",350.494,10,false,0,"https://unlibroparaestanoche.files.wordpress.com/2015/08/el-marciano-andy-weir.jpg")
        listBook[countBook]= Book(countBook +1,"Ready Player One ","Ernest Clin","Ciencia Ficción",344.521,10,true,0,"https://media.standaardboekhandel.be/-/media/mdm/product/9780099560432/frontImagesLink.img?rev=2202908469&hash=0C242D9AA61D3E39F0BFB291A3441BFB")
        listBook[countBook]= Book(countBook +1,"World War Z","Max Brooks","Ciencia Ficción",338.548,10,false,0,"https://th.bing.com/th/id/R.e89ea5011d79cb253aae7411a769c131?rik=Gv9sz%2fWj4klvDw&riu=http%3a%2f%2f1.bp.blogspot.com%2f-UT7uyRAsz1c%2fUgQRARsmOKI%2fAAAAAAAABJE%2f5SZAg6cIymQ%2fs1600%2fworld%2bwar%2bz.jpg&ehk=WvzaZt9TYf12l3WFOXBDBcd9NiVC4tFUhaLBnlSaTmY%3d&risl=&pid=ImgRaw&r=0")
        listBook[countBook]= Book(countBook +1,"American Gods","Neil Gaiman","Ciencia Ficción",332.575,10,false,0, "https://th.bing.com/th/id/R.abf127f97da6e37139bcac2ffd3df1cc?rik=lB9sS1suBxI2Hw&riu=http%3a%2f%2fmedia.comicbook.com%2fwp-content%2fuploads%2f2013%2f06%2fneil-gaiman-american-gods.jpg&ehk=w3ttEyHBP7a81NgQqME6BEeSJtnt6G7QGExzoFsRccw%3d&risl=&pid=ImgRaw&r=0")

        listBook[countBook]= Book(countBook +1,"Desfiladero de la absolución","Alastair Reynolds","Ciencia Ficción",326.602,10,false,0, "https://th.bing.com/th/id/OIP.yJExSTU2pMJMJW-PW_NkJAAAAA?pid=ImgDet&rs=1")
        listBook[countBook]= Book(countBook +1,"El jugador","Iain M. Banks","Ciencia Ficción",320.629,10,false,0,"https://i.ebayimg.com/images/g/0JIAAOSwVH1fpn9t/s-l300.jpg")
        listBook[countBook]= Book(countBook +1,"The Expanse","James S.A. Corey","Ciencia Ficción",314.656,10,true,0, "https://th.bing.com/th/id/R.844b6a3bc7489735f2538cdf1ca24f4d?rik=7TDdqgrmsOaC6g&pid=ImgRaw&r=0")
        listBook[countBook]= Book(countBook +1,"Qualityland","Marc-Uwe Kling","Ciencia Ficción",308.683,10,false,0, "https://th.bing.com/th/id/OIP.0FktCArdFrGLK9zfnMw-1wHaLi?pid=ImgDet&rs=1")
        listBook[countBook]= Book(countBook +1,"Las estrellas son legión","Kameron Hurley","Ciencia Ficción",302.71,10,false,0, "https://publibros.com/wp-content/uploads/2018/10/250762_")
        listBook[countBook]= Book(countBook +1,"Embassytown: La Ciudad Embajada de ","China Mieville:","Ciencia Ficción",296.737,10,true,0,"https://2.bp.blogspot.com/-ZTojK_u_rXI/Uzn7_gw7h5I/AAAAAAAAJlk/VvIux5Geu7c/s1600/Embassytown+3.jpg")
        listBook[countBook]= Book(countBook +1,"Orgullo y Prejuicio","Jane Austen","Romance",290.764,10,false,0,"https://th.bing.com/th/id/R.f1c00120f25903ed6f4c73abcb700397?rik=vIjp3XuLs%2fwQUA&pid=ImgRaw&r=0")

        listBook[countBook]= Book(countBook +1,"Emma","Jane Austen","Romance",284.791,10,false,0, "https://resizing.flixster.com/Xy7ZBEcL-QBkBFuiMHF26eGqTwg=/ems.ZW1zLXByZC1hc3NldHMvbW92aWVzLzJkM2IwYzEwLTllZDQtNDVmZC04NmYwLTllNmY1MTZmYjNiNC53ZWJw")
        listBook[countBook]= Book(countBook +1,"Sentido y Sensibilidad","Jane Austen","Romance",278.818,10,false,0, "https://th.bing.com/th/id/R.86012c8fbb27aaa958cb7410ab523fd7?rik=jfMIrS5PsGED0g&riu=http%3a%2f%2fimage.casadellibro.com%2flibros%2f0%2fsentido-y-sensibilidad-ebook-9788499896601.jpg&ehk=fXJlTUy%2bw656nfxsAQfB7vPyFg70bbtF6u3RLErjbBo%3d&risl=&pid=ImgRaw&r=0")
        listBook[countBook]= Book(countBook +1,"La antigua magia","Lisa Kleypas","Romance",272.845,10,true,0,"https://th.bing.com/th/id/OIP.2DR2FcuHha3jOCKDuXuGgAHaLZ?pid=ImgDet&rs=1")
        listBook[countBook]= Book(countBook +1,"Tuya a Medianoche","Lisa Kleypas","Romance",266.872,10,false,0, "https://th.bing.com/th/id/R.363d3c14ac3f28bb0d22dad1ff4f7b5d?rik=tua3Qbu2iJFJEg&riu=http%3a%2f%2fm1.paperblog.com%2fi%2f140%2f1402826%2fresena-tuya-medianoche-lisa-kleypas-L-FH7sej.jpeg&ehk=mC7%2bsC%2bA52BWF7ceawD4S7ISBujXYl65yxtiZz9fpSc%3d&risl=&pid=ImgRaw&r=0")
        listBook[countBook]= Book(countBook +1,"Tentación al Anochecer","Lisa Kleypas","Romance",260.899,10,false,0, "https://i.pinimg.com/originals/5b/59/10/5b59104c9af007fc6a210987bf4d5a8a.jpg")
        listBook[countBook]= Book(countBook +1,"Secretos de una noche de verano","Lisa Kleypas","Romance",254.926,10,false,0, "https://th.bing.com/th/id/R.4e01990cd3c33c8538492be46ce04ddb?rik=2gYaaIbqLpkHpA&riu=http%3a%2f%2f1.bp.blogspot.com%2f-o8VLkMx51GU%2fU9iWWh9upnI%2fAAAAAAAAANI%2fe8cv3s7MPoU%2fs1600%2fSecretos%2bde%2buna%2bnoche%2bde%2bverano.jpg&ehk=6fWsQpfiejI%2faJcUF9KiB3yrmxWfwtV2eZHfJlE17l0%3d&risl=&pid=ImgRaw&r=0")
        listBook[countBook]= Book(countBook +1,"Casarse con él","Lisa Kleypas","Romance",248.953,10,true,0, "https://th.bing.com/th/id/OIP.quBN6LgX3Nz7IRJeUfo9swAAAA?pid=ImgDet&rs=1")

        listBook[countBook]= Book(countBook +1,"Una tentación para el Duque","Lorraine Heath","Romance",242.98,10,false,0,"https://th.bing.com/th/id/R.742dfb9b19c13043365fdf8cd60dd610?rik=AqvOEmlCSuSvnw&pid=ImgRaw&r=0")
        listBook[countBook]= Book(countBook +1,"Jane Eyre","Lorraine Heath","Romance",237.007,10,false,0,"https://th.bing.com/th/id/R.5d7cc8ebe66348fc1e986bd1fa2f0dd0?rik=vERjhCOuM8v8ng&riu=http%3a%2f%2fwww.blackeyedtheatre.co.uk%2fwp-content%2fuploads%2f2020%2f05%2fJane-Eyre-Programme-710x1024.jpg&ehk=NuJhvEU8tyn3MtMACdHVt6vVKitoTeIn3nVym1hkhlE%3d&risl=&pid=ImgRaw&r=0")
        listBook[countBook]= Book(countBook +1,"POEMA DE GILGAMESH","Autor anonimo","Historia",231.034,10,false,0,"https://imgv2-1-f.scribdassets.com/img/word_document/344549329/original/2c86058bfd/1587514570?v=1")
        listBook[countBook]= Book(countBook +1,"Libro De Job","Autor anonimo","Historia",225.061,10,true,0, "https://th.bing.com/th/id/R.4ad9ad4973c0d1a312155e795eb8e940?rik=%2bzhsAHWB2acIPQ&riu=http%3a%2f%2feditorial-humanitas.com%2f2353-thickbox_default%2flibro-de-job.jpg&ehk=HMVdkpTY8wAW0l5gaCeb5xon81gTDSf2kT1Ze8IgTU8%3d&risl=&pid=ImgRaw&r=0")
        listBook[countBook]= Book(countBook +1,"Las mil y una noches","Autor anonimo","Historia",219.088,10,false,0,"https://www.planetadelibros.com.ar/usuaris/libros/fotos/198/m_libros/portada_las-mil-y-una-noches_anonimo_201502271755.jpg")
        listBook[countBook]= Book(countBook +1,"Saga de njal","Autor Anonimo","Historia",213.115,10,false,0,"https://guiascostarica.info/edel/wp-content/uploads/2014/04/saga_njal-200x300.jpg")
        listBook[countBook]= Book(countBook +1,"Todo se desmorona", "Chinua Achebe","Historia",207.142,10,true,0,"https://th.bing.com/th/id/OIP.yCtomu6w8lwxO37wA3oJTgHaLV?pid=ImgDet&rs=1")

        listBook[countBook]= Book(countBook +1,"Cuentos Infantiles", "Hans Christian Andersen","Historia",201.169,10,false,0,"https://www.elsotano.com/imagenes/9789583/978958300431.JPG")
        listBook[countBook]= Book(countBook +1,"Divina comedia", "Dante Alighieri","Historia",195.196,10,false,0, "https://th.bing.com/th/id/R.0112ee17f821f4d7e69bd992cbf98a3c?rik=5XOqXH2KlKiGjw&riu=http%3a%2f%2flibrosysolucionarios.net%2fwp-content%2fuploads%2f2014%2f09%2fla-divina-comedia-dante-alighieri-_MLA-F-143327261_7646.jpg&ehk=O9n64KVWGP27tE%2bgLK0OEALjq2M0XnYlNnOEnmiy3Xk%3d&risl=&pid=ImgRaw&r=0")
        listBook[countBook]= Book(countBook +1,"Papá Goriot", "Honoré de Balzac","Historia",189.223,10,false,0,"https://th.bing.com/th/id/OIP.ZHj3AJPMwrqHwmA5wXFzogHaLZ?pid=ImgDet&rs=1")
        listBook[countBook]= Book(countBook +1,"Molloy", "Samuel Beckett","Historia",183.25,10,false,0,"https://th.bing.com/th/id/R.5605dbfe9c1d16d0bf9a733a634820b9?rik=zZ0IzB467wFt0g&pid=ImgRaw&r=0")
        listBook[countBook]= Book(countBook +1,"Decameron", "Giovanni Boccaccio","Historia",177.277,10,false,0,"https://th.bing.com/th/id/OIP.81q2weWcbhOFbjSIf3LN_AHaKq?pid=ImgDet&rs=1")
    }
}