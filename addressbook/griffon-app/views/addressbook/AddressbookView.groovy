package addressbook

application(title: 'addressbook',
  pack: true,
  resizable: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    menuBar {
        menu('Contacts') {
        }
    }
    migLayout(layoutConstraints: 'fill')
    scrollPane(constraints: 'west') {
        list()
    }
    panel(constraints: 'center, grow', border: titledBorder(title: 'Contact')) {
        label('content')
    }
    panel(constraints: 'east, grow', border: titledBorder(title: 'Actions')) {
        label('content')
    }
}
