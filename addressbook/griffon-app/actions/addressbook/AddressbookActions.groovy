package addressbook

action(id: 'newAction',
    name: 'New',
    mnemonic: 'N',
    accelerator: 'meta N',
    closure: controller.newAction)
action(id: 'saveAction',
    name: 'Save',
    mnemonic: 'S',
    accelerator: 'meta S',
    closure: controller.saveAction)
action(id: 'deleteAction',
    name: 'Delete',
    closure: controller.deleteAction)
action(id: 'dumpAction',
    name: 'Dump',
    mnemonic: 'D',
    accelerator: 'meta D',
    closure: controller.&dumpAction)